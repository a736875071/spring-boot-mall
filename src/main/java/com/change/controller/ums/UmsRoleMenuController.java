package com.change.controller.ums;

import com.change.common.api.CommonResult;
import com.change.dto.UmsRoleMenuParam;
import com.change.model.ums.UmsRoleMenuRelation;
import com.change.service.UmsRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色-菜单
 *
 * @author YangQ
 * @date 2020/3/20 11:43
 */
@RestController
@Api(tags = "角色菜单管理")
public class UmsRoleMenuController {
    @Autowired
    private UmsRoleMenuService umsRoleMenuService;

    @ApiOperation("获取角色对应的菜单列表")
    @RequestMapping(value = "/role-menu/list", method = RequestMethod.GET)
    public CommonResult<List<UmsRoleMenuRelation>> getMenuListByRoleId(Long roleId) {
        List<UmsRoleMenuRelation> roleMenus = umsRoleMenuService.getMenuListByRoleId(roleId);
        return CommonResult.success(roleMenus);
    }

    @ApiOperation("修改角色关联菜单")
    @RequestMapping(value = "/role-menu/update/{roleId}", method = RequestMethod.PATCH)
    public CommonResult<Boolean> updateMenuByRoleId(@PathVariable Long roleId, @RequestBody UmsRoleMenuParam umsRoleMenuParam) {
        umsRoleMenuParam.setRoleId(roleId);
        umsRoleMenuService.updateMenuByRoleId(umsRoleMenuParam);
        return CommonResult.success(Boolean.TRUE);
    }

}
