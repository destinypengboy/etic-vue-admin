package top._867007845.common.exception.user;

import top._867007845.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author 867007845
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
