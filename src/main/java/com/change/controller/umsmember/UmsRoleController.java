package com.change.controller.umsmember;

import com.change.common.api.CommonResult;
import com.change.model.ums.UmsRole;
import com.change.model.ums.UmsRoleCondition;
import com.change.service.UmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户角色
 *
 * @author YangQ
 * @date 2020/3/20 11:43
 */
@RestController
public class UmsRoleController {
    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("获取角色列表")
    @RequestMapping(value = "/roles/list", method = RequestMethod.GET)
    public CommonResult<List<UmsRole>> getRoleList(UmsRoleCondition condition) {
        List<UmsRole> umsRoles = umsRoleService.getRoleList(condition);
        return CommonResult.success(umsRoles);
    }

    @ApiOperation("创建角色")
    @RequestMapping(value = "/roles/create", method = RequestMethod.POST)
    public CommonResult<Boolean> createRole(@RequestBody UmsRole umsRole) {
        return CommonResult.success(umsRoleService.createRole(umsRole));
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "/roles/delete/{id}", method = RequestMethod.DELETE)
    public CommonResult<Boolean> deleteRoleById(@PathVariable Long id) {
        return CommonResult.success(umsRoleService.deleteRoleById(id));
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/roles/update/{id}", method = RequestMethod.PATCH)
    public CommonResult<Boolean> updateRoleById(@PathVariable Long id, @RequestBody UmsRole umsRole) {
        umsRole.setId(id);
        return CommonResult.success(umsRoleService.updateRoleById(umsRole));
    }
}
