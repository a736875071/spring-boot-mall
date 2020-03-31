package com.change.dto;

import com.change.model.ums.UmsMenu;
import lombok.Data;

import java.util.List;

/**
 * @author change
 */
@Data
public class UmsMenuDto extends UmsMenu {
    private List<UmsMenuDto> children;
}