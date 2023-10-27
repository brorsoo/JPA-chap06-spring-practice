package com.brorsoo.springjpa.category.service;

import com.brorsoo.springjpa.category.dto.CategoryDTO;
import com.brorsoo.springjpa.category.entity.Category;
import com.brorsoo.springjpa.category.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDTO> findCategoryList() {

        List<Category> categoryList = categoryRepository.findAll(Sort.by("categoryCode"));

        return categoryList.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }


    public List<CategoryDTO> findByRefCategoryCodeIsNull() {

        List<Category> categoryList = categoryRepository.findByRefCategoryCodeIsNull();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }


    public List<CategoryDTO> findByRefCategoryCodeIsNotNullAndRefCategoryCode(int categoryCode) {

        List<Category> categoryList
                = categoryRepository.findByRefCategoryCodeIsNotNullAndRefCategoryCode(categoryCode);

        return categoryList.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }


    public List<CategoryDTO> findByCategoryNameContaining(String categoryName) {

        List<Category> categoryList
                = categoryRepository.findByCategoryNameContaining(categoryName);

        return categoryList.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }

}
