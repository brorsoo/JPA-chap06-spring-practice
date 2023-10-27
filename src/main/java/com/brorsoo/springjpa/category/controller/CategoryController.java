package com.brorsoo.springjpa.category.controller;

import com.brorsoo.springjpa.category.dto.CategoryDTO;
import com.brorsoo.springjpa.category.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String findCategoryList(Model model) {

        List<CategoryDTO> categoryList = categoryService.findCategoryList();
        model.addAttribute("categoryList", categoryList);

        return "category/list";
    }

    @GetMapping("/keyword")
    public void keywordPage() {

    }

    @GetMapping("/keywordSearch")
    public String keywordSearch(@RequestParam String categoryName, Model model) {

        List<CategoryDTO> categoryList = categoryService.findByCategoryNameContaining(categoryName);

        model.addAttribute("categoryList", categoryList);

        return "category/keywordResult";
    }

    @GetMapping("/firstList")
    public void firstListPage() {
    }


    @GetMapping("/first")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return categoryService.findByRefCategoryCodeIsNull();
    }

    @GetMapping("/search")
    public String findSecondCategoryList(@RequestParam int categoryCode, Model model) {

        List<CategoryDTO> categoryList = categoryService.findByRefCategoryCodeIsNotNullAndRefCategoryCode(categoryCode);

        model.addAttribute("categoryList", categoryList);

        return "category/secondList";
    }



}
