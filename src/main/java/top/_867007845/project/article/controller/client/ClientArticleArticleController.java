package top._867007845.project.article.controller.client;

import org.springframework.web.bind.annotation.*;
import top._867007845.common.utils.spring.SpringUtils;
import top._867007845.framework.web.domain.AjaxResult;
import top._867007845.project.article.dto.ArticleListQueryDto;
import top._867007845.project.article.service.client.ClientArticleArticleService;
import top._867007845.project.article.service.client.ClientArticleNavService;


@RestController
@RequestMapping("/client/article/article")
public class ClientArticleArticleController {

    @PostMapping("list/query")
    public AjaxResult listQuery(
            @RequestBody ArticleListQueryDto articleListQueryDto
    ) {
        return AjaxResult.success(SpringUtils.getBean(ClientArticleArticleService.class).listQuery(articleListQueryDto));
    }

    @GetMapping("detail/query")
    public AjaxResult detailQuery(
            @RequestParam Long id
    ) {
        return AjaxResult.success(SpringUtils.getBean(ClientArticleArticleService.class).detailQuery(id));
    }

}
