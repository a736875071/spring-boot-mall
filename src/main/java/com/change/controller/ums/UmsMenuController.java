package com.change.controller.ums;

import com.change.common.api.CommonResult;
import com.change.model.ums.UmsMenu;
import com.change.dto.UmsMenuCondition;
import com.change.service.UmsMenuService;
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
@Api(tags = "菜单管理")
public class UmsMenuController {
    @Autowired
    private UmsMenuService umsMenuService;

    @ApiOperation("获取菜单列表")
    @RequestMapping(value = "/menus/list", method = RequestMethod.GET)
    public CommonResult<List<UmsMenu>> getRoleList(UmsMenuCondition condition) {
        List<UmsMenu> umsMenus = umsMenuService.getUmsMenuList(condition);
        return CommonResult.success(umsMenus);
    }

    @ApiOperation("创建菜单")
    @RequestMapping(value = "/menus/create", method = RequestMethod.POST)
    public CommonResult<Boolean> createRole(@RequestBody UmsMenu umsMenu) {
        return CommonResult.success(umsMenuService.createMenu(umsMenu));
    }

    @ApiOperation("删除菜单")
    @RequestMapping(value = "/menus/delete/{id}", method = RequestMethod.DELETE)
    public CommonResult<Boolean> deleteRoleById(@PathVariable Long id) {
        return CommonResult.success(umsMenuService.deleteMenuById(id));
    }

    @ApiOperation("修改菜单")
    @RequestMapping(value = "/menus/update/{id}", method = RequestMethod.PATCH)
    public CommonResult<Boolean> updateRoleById(@PathVariable Long id, @RequestBody UmsMenu umsMenu) {
        umsMenu.setId(id);
        return CommonResult.success(umsMenuService.updateMenuById(umsMenu));
    }
}
