package top._867007845.project.article.service.client;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top._867007845.project.article.domain.ArticleNav;
import top._867007845.project.article.mapper.ArticleNavMapper;

import java.util.List;

@Service
public class ClientArticleNavService extends ServiceImpl<ArticleNavMapper, ArticleNav> {

    public List<ArticleNav> listQuery() {
        return this.list(new LambdaQueryWrapper<ArticleNav>().eq(ArticleNav::getStatus, "0").orderByAsc(ArticleNav::getOrderNum));
    }
}
