package top._867007845.project.test;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top._867007845.framework.web.page.TableDataInfo;
import top._867007845.project.tool.gen.domain.GenTable;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/job")
public class JobTestController {

    @PostMapping("/test01")
    public void test01(@RequestBody Map<String,Object> params)
    {
        System.out.println(JSONObject.toJSONString(params));
        System.out.println("测试001");
    }

    @PostMapping("/test02")
    public void test02()
    {
        System.out.println("测试002");
    }

    @PostMapping("/test03")
    public void test03()
    {
        System.out.println("测试003");
    }
}
