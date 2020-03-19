package com.change.common.api;

/**
 * 封装API的错误码
 *
 * @author macro
 * @date 2019/4/19
 */
public interface IErrorCode {
    /**
     * 获取code
     *
     * @return
     */
    long getCode();

    /**
     * 获取mes
     *
     * @return
     */
    String getMessage();
}
