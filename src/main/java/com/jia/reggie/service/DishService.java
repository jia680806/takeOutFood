package com.jia.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jia.reggie.dto.DishDto;
import com.jia.reggie.entity.Dish;


public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);
     DishDto getByIdWithFlavor(Long id);

     void updateWithFlavor(DishDto dishDto);

}

