package top._867007845.common.exception.file;

import top._867007845.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author 867007845
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
