package com.jia.reggie.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jia.reggie.common.CustomException;
import com.jia.reggie.entity.Category;
import com.jia.reggie.entity.Dish;
import com.jia.reggie.entity.Setmeal;
import com.jia.reggie.mapper.CategoryMapper;
import com.jia.reggie.service.CategoryService;
import com.jia.reggie.service.DishService;
import com.jia.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;


    @Override
    public void remove(Long id) {

        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        dishQueryWrapper.eq(Dish::getCategoryId,id);
        int cont1 = dishService.count(dishQueryWrapper);
        if(cont1>0){
            throw new CustomException("当前分类关联了菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealQueryWrapper = new LambdaQueryWrapper<>();
        setmealQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealQueryWrapper);
        if (count2>0){
            throw new CustomException("当前分类关联了套餐，不能删除");
        }

        super.removeById(id);

    }
}
