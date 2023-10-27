package com.brorsoo.springjpa.category.repository;


import com.brorsoo.springjpa.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // ref코드가 null인 것을 조회
    public List<Category> findByRefCategoryCodeIsNull();
    // ref코드가 null이 아닌 것 and 입력받은 categoryCode 를 조회
    public List<Category> findByRefCategoryCodeIsNotNullAndRefCategoryCode(int categoryCode);
    // 키워드로 카테고리 목록 조회
    public List<Category> findByCategoryNameContaining(String categoryName);

}
