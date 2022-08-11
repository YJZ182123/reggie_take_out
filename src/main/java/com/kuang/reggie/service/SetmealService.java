package com.kuang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuang.reggie.dto.SetmealDto;
import com.kuang.reggie.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐，保存他和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时删除关联菜品
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
