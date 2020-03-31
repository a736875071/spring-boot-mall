package com.change.dto;

import lombok.Data;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/23 10:33
 */
@Data
public class UmsRoleMenuParam {
    private Long roleId;
    private List<Long> menuIds;
}
