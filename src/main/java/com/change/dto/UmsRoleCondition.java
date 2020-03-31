package com.change.dto;

import lombok.Data;

import java.util.List;

/**
 * @author change
 */
@Data
public class UmsRoleCondition {
    private String name;
    private List<Long> ids;

}