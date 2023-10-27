package com.brorsoo.springjpa.category.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CategoryDTO {

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}
