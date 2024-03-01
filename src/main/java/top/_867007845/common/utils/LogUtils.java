package top._867007845.common.utils;

/**
 * 处理并记录日志文件
 * 
 * @author 867007845
 */
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
