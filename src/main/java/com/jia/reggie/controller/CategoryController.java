package com.jia.reggie.controller;


import com.jia.reggie.common.R;
import com.jia.reggie.entity.Category;
import com.jia.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public R<String> save (@RequestBody Category category){
        log.info("category:"+category);
        categoryService.save(category);
        return R.success("新增分类成功");

    }

}
