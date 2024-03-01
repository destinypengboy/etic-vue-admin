package top._867007845.project.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top._867007845.common.utils.StringUtils;
import top._867007845.framework.config.AppConfig;

/**
 * 首页
 *
 * @author 867007845
 */
@RestController
public class SysIndexController
{
    /** 系统基础配置 */
    @Autowired
    private AppConfig appConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", appConfig.getName(), appConfig.getVersion());
    }
}
