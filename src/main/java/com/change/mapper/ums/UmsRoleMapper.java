package com.change.mapper.ums;

import com.change.model.ums.UmsRole;
import com.change.dto.UmsRoleCondition;

import java.util.List;

/**
 * @author change
 */
public interface UmsRoleMapper {

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);


    /**
     * 新增角色
     *
     * @param record
     * @return
     */
    int insertSelective(UmsRole record);

    /**
     * 条件查询角色
     *
     * @param condition
     * @return
     */
    List<UmsRole> selectByExample(UmsRoleCondition condition);

    /**
     * 主键查询角色
     *
     * @param id
     * @return
     */
    UmsRole selectByPrimaryKey(Long id);

    /**
     * 新增角色
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UmsRole record);

}