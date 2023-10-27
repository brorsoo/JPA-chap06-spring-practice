package com.brorsoo.springjpa.category.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
@Getter @Setter @ToString
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}
