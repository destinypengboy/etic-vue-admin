package top._867007845.project.article.controller.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top._867007845.common.utils.spring.SpringUtils;
import top._867007845.framework.web.domain.AjaxResult;
import top._867007845.project.article.service.client.ClientArticleNavService;


@RestController
@RequestMapping("/client/article/nav")
public class ClientArticleNavController {

    @GetMapping("list/query")
    public AjaxResult listQuery() {
        return AjaxResult.success(SpringUtils.getBean(ClientArticleNavService.class).listQuery());
    }

}
