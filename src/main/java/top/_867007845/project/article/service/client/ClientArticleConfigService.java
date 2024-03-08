package top._867007845.project.article.service.client;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top._867007845.common.utils.spring.SpringUtils;
import top._867007845.framework.redis.RedisCache;
import top._867007845.project.article.domain.ArticleConfig;
import top._867007845.project.article.mapper.ArticleConfigMapper;

import java.util.Map;

import static top._867007845.project.article.constants.ArticleRedisConstant.ARTICLE_CONFIG_DETAIL;

@Service
public class ClientArticleConfigService extends ServiceImpl<ArticleConfigMapper, ArticleConfig> {



    public Map<String, Object> detailQuery(String configKey) {
        return SpringUtils.getBean(RedisCache.class).getCacheMap(ARTICLE_CONFIG_DETAIL + configKey);
    }
}
