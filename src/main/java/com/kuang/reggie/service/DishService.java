package com.kuang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuang.reggie.dto.DishDto;
import com.kuang.reggie.entity.Dish;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据库，需要操作两张表
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新口味信息
    public void updateWithFlavor(DishDto dishDto);
}
