package com.change.config.exception;

import lombok.Getter;

/**
 * @author YangQ
 * @date 2020/3/24 15:30
 */
@Getter
public class MsgException extends RuntimeException {
    private int code;
    private String msg;

    public MsgException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
