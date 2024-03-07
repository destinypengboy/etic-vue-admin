package top._867007845.common.utils.job;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import top._867007845.common.utils.http.HttpUtils;
import top._867007845.project.monitor.domain.SysJob;

/**
 * 任务执行工具
 *
 * @author 867007845
 */
public class JobInvokeUtil
{
    /**
     * 执行方法
     *
     * @param sysJob 系统任务
     */
    public static void invokeMethod(SysJob sysJob) {
        String invokeTarget = sysJob.getInvokeTarget();
        // http请求接口
        HttpUtil.post(invokeTarget, sysJob.getRequestBody());
    }
}
