package top._867007845.framework.aspectj.lang.enums;

/**
 * 限流类型
 *
 * @author 867007845
 */

public enum LimitType
{
    /**
     * 默认策略全局限流
     */
    DEFAULT,

    /**
     * 根据请求者IP进行限流
     */
    IP
}
