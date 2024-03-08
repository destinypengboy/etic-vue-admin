package top._867007845.project.article.service.client;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top._867007845.common.utils.DateUtils;
import top._867007845.common.utils.spring.SpringUtils;
import top._867007845.framework.redis.RedisCache;
import top._867007845.project.article.domain.ArticleArticle;
import top._867007845.project.article.domain.ArticleCategory;
import top._867007845.project.article.domain.ArticleTag;
import top._867007845.project.article.dto.ArticleListQueryDto;
import top._867007845.project.article.mapper.ArticleArticleMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static top._867007845.project.article.constants.ArticleRedisConstant.*;

@Service
public class ClientArticleArticleService extends ServiceImpl<ArticleArticleMapper, ArticleArticle> {


    public JSONObject listQuery(ArticleListQueryDto articleListQueryDto) {
        JSONObject res = new JSONObject();
        // 文章从缓存中读取
        List<ArticleArticle> articleList = SpringUtils.getBean(RedisCache.class).getCacheList(ARTICLE_ARTICLE_LIST);
        // 标签从缓存中读取
        List<ArticleTag> tagList = SpringUtils.getBean(RedisCache.class).getCacheList(ARTICLE_TAG_LIST);
        // 分组从缓存中读取
        List<ArticleCategory> cateList = SpringUtils.getBean(RedisCache.class).getCacheList(ARTICLE_CATE_LIST);
        if (CollUtil.isNotEmpty(articleListQueryDto.getTagIds())) {
            articleList = articleList.stream().filter(a -> {
                List<Long> articleTagIds = JSONArray.parseArray(a.getTagIdList(), Long.class);
                return CollUtil.isNotEmpty(articleTagIds) && CollUtil.containsAny(articleTagIds, articleListQueryDto.getTagIds());
            }).collect(Collectors.toList());
        }
        if (CollUtil.isNotEmpty(articleListQueryDto.getCateIds())) {
            articleList = articleList.stream().filter(a -> {
                List<Long> articleCategoryIds = JSONArray.parseArray(a.getCategoryIdList(), Long.class);
                return CollUtil.isNotEmpty(articleCategoryIds) && CollUtil.containsAny(articleCategoryIds, articleListQueryDto.getCateIds());
            }).collect(Collectors.toList());
        }
        if (articleListQueryDto.getPaged()) {
            // 分页查询
            if (CollUtil.isEmpty(articleList)) {
                res.put("list", new ArrayList<>());
                res.put("total", 0L);
                return res;
            }
            Integer pageNo = articleListQueryDto.getPageNo();
            Integer pageSize = articleListQueryDto.getPageSize();
            List<ArticleArticle> collect = articleList.stream().skip((long) (pageNo - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            JSONArray list = new JSONArray();
            collect.forEach(c -> {
                list.add(detailToRecord(c, tagList, cateList));
            });
            res.put("list", list);
            res.put("total", articleList.size());
        } else {
            // 不分页查询
            if (CollUtil.isEmpty(articleList)) {
                return res;
            }
            List<ArticleArticle> finalArticleList = articleList;
            if (articleListQueryDto.getTagGrouped()) {
                tagList.forEach(item -> {
                    res.put(item.getTagTitle(), finalArticleList.stream().filter(a -> JSONArray.parseArray(a.getTagIdList(), Long.class).contains(a.getId())).collect(Collectors.toList()));
                });
                res.put("其他", finalArticleList.stream().filter(a -> CollUtil.isEmpty(JSONArray.parseArray(a.getTagIdList(), Long.class))).collect(Collectors.toList()));
            }
            if (articleListQueryDto.getCateGrouped()) {
                cateList.forEach(item -> {
                    res.put(item.getCategoryTitle(), finalArticleList.stream().filter(a -> JSONArray.parseArray(a.getCategoryIdList(), Long.class).contains(a.getId())).collect(Collectors.toList()));
                });
                res.put("其他", finalArticleList.stream().filter(a -> CollUtil.isEmpty(JSONArray.parseArray(a.getCategoryIdList(), Long.class))).collect(Collectors.toList()));
            }
            if (articleListQueryDto.getTimeGrouped()) {
                List<String> timeList = finalArticleList.stream().map(ArticleArticle::getCreateTime).sorted(Comparator.reverseOrder()).map(DateUtils::dateTime).collect(Collectors.toList());
                timeList.forEach(item -> {
                    res.put(item, finalArticleList.stream().filter(a -> DateUtils.dateTime(a.getCreateTime()).equals(item)).collect(Collectors.toList()));
                });
            }
        }
        return res;
    }

    public JSONObject detailQuery(Long id) {
        ArticleArticle article = this.getById(id);
        // 标签从缓存中读取
        List<ArticleTag> tagList = SpringUtils.getBean(RedisCache.class).getCacheList(ARTICLE_TAG_LIST);
        // 分组从缓存中读取
        List<ArticleCategory> cateList = SpringUtils.getBean(RedisCache.class).getCacheList(ARTICLE_CATE_LIST);
        return detailToRecord(article, tagList, cateList);
    }

    private JSONObject detailToRecord(ArticleArticle article, List<ArticleTag> tagList, List<ArticleCategory> cateList) {
        JSONObject record = JSONObject.from(article);
        record.remove("tagIdList");
        record.remove("categoryIdList");
        record.put("tagList", tagList.stream().filter(
                t -> JSONArray.parseArray(article.getTagIdList(), Long.class).contains(t.getId())
        ).collect(Collectors.toList()));
        record.put("categoryList", cateList.stream().filter(
                t -> JSONArray.parseArray(article.getCategoryIdList(), Long.class).contains(t.getId())
        ).collect(Collectors.toList()));
        return record;
    }
}
