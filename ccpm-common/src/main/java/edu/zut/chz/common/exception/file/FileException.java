package edu.zut.chz.common.exception.file;

import edu.zut.chz.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author anmingnuo
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
