package com.change.mapper.ums;

import com.change.model.ums.UmsMenu;
import com.change.dto.UmsMenuCondition;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/20 11:54
 */
public interface UmsMenuMapper {

    /**
     * 查询菜单列表
     *
     * @param condition
     * @return 结果
     */
    List<UmsMenu> getUmsMenuList(UmsMenuCondition condition);

    /**
     * 创建菜单
     *
     * @param umsMenu
     * @return
     */
    Boolean createMenu(UmsMenu umsMenu);

    /**
     * 修改菜单
     *
     * @param umsMenu
     * @return
     */
    Boolean updateMenuById(UmsMenu umsMenu);

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    Boolean deleteMenuById(Long id);

}
