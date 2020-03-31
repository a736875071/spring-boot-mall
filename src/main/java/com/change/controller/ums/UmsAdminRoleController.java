package com.change.controller.ums;

import com.change.common.api.CommonResult;
import com.change.dto.AdminRoleMenuDto;
import com.change.dto.AdminRoleMenuTreeDto;
import com.change.dto.UmsAdminRoleParam;
import com.change.model.ums.UmsAdminRoleRelation;
import com.change.service.UmsAdminRoleService;
import io.swagger.annotations.Api;
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
@Api(tags = "用户角色关系管理")
public class UmsAdminRoleController {
    @Autowired
    private UmsAdminRoleService umsAdminRoleService;


    @ApiOperation("修改用户角色")
    @RequestMapping(value = "/admin-roles/update/{adminId}", method = RequestMethod.PATCH)
    public CommonResult updateRoleById(@PathVariable Long adminId, @RequestBody UmsAdminRoleParam param) {
        param.setAdminId(adminId);
        umsAdminRoleService.updateAdminRole(param);
        return CommonResult.success();
    }

    @ApiOperation("查看用户角色")
    @RequestMapping(value = "/admin-roles/find/{adminId}", method = RequestMethod.GET)
    public CommonResult<List<UmsAdminRoleRelation>> findAdminRoleByAdminId(@PathVariable Long adminId) {
        return CommonResult.success(umsAdminRoleService.findAdminRoleByAdminId(adminId));
    }

    @ApiOperation("查看用户角色及菜单")
    @RequestMapping(value = "/admin-roles/menu/{adminId}", method = RequestMethod.GET)
    public CommonResult<AdminRoleMenuDto> findRoleAndMenuByAdminId(@PathVariable Long adminId) {
        return CommonResult.success(umsAdminRoleService.findRoleAndMenuByAdminId(adminId));
    }

    @ApiOperation("查看用户角色及菜单(菜单树型)")
    @RequestMapping(value = "/admin-roles/menu-tree/{adminId}", method = RequestMethod.GET)
    public CommonResult<AdminRoleMenuTreeDto> findRoleAndMenuTreeByAdminId(@PathVariable Long adminId) {
        return CommonResult.success(umsAdminRoleService.findRoleAndMenuTreeByAdminId(adminId));
    }
}
