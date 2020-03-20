package com.change.common;

import lombok.*;

/**
 * @author YangQ
 * @date 2020/3/20 14:11
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum PublicStatus {
    /**
     * 禁用
     */
    FORBIDDEN(0, "禁用"),
    /**
     * 启用
     */
    ENABLED(1, "启用");
    private int code;
    private String desc;
}
