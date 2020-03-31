package com.change.model.ums;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author change
 */
@Data
public class UmsRoleMenuRelation {
    private Long id;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;
}