package com.change.mapper.ums;

import com.change.model.ums.UmsAdminRoleRelation;
import com.change.model.ums.UmsAdminRoleRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author change
 */
public interface UmsAdminRoleRelationMapper {
    /**
     * 通过用户id删除所有角色
     *
     * @param adminId 用户id
     * @return 结果
     */
    int deleteAdminRoleRelationByAdminId(Long adminId);

    /**
     * 批量新增用户角色关系
     *
     * @param relations 角色关系
     * @return 结果
     */
    int addBatchAdminRoleRelation(@Param("relations") List<UmsAdminRoleRelation> relations);

    /**
     * 通过用户查询用户关联角色信息
     *
     * @param adminId
     * @return 结果
     */
    List<UmsAdminRoleRelation> findAdminRoleByAdminId(Long adminId);


    int countByExample(UmsAdminRoleRelationExample example);

    int deleteByExample(UmsAdminRoleRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminRoleRelation record);

    int insertSelective(UmsAdminRoleRelation record);

    List<UmsAdminRoleRelation> selectByExample(UmsAdminRoleRelationExample example);

    UmsAdminRoleRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsAdminRoleRelation record, @Param("example") UmsAdminRoleRelationExample example);

    int updateByExample(@Param("record") UmsAdminRoleRelation record, @Param("example") UmsAdminRoleRelationExample example);

    int updateByPrimaryKeySelective(UmsAdminRoleRelation record);

    int updateByPrimaryKey(UmsAdminRoleRelation record);
}