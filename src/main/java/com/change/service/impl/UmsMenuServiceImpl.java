package com.change.service.impl;

import com.change.mapper.ums.UmsMenuMapper;
import com.change.model.ums.UmsMenu;
import com.change.dto.UmsMenuCondition;
import com.change.service.UmsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/24 17:14
 */
@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired
    private UmsMenuMapper umsMenuMapper;

    @Override
    public List<UmsMenu> getUmsMenuList(UmsMenuCondition condition) {
        return umsMenuMapper.getUmsMenuList(condition);
    }

    @Override
    public Boolean createMenu(UmsMenu umsMenu) {
        return umsMenuMapper.createMenu(umsMenu);
    }

    @Override
    public Boolean updateMenuById(UmsMenu umsMenu) {
        return umsMenuMapper.updateMenuById(umsMenu);
    }

    @Override
    public Boolean deleteMenuById(Long id) {
        return umsMenuMapper.deleteMenuById(id);
    }
}
