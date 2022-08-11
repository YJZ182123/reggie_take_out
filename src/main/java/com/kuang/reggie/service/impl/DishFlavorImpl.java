package com.kuang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuang.reggie.entity.DishFlavor;
import com.kuang.reggie.mapper.DishFlavorMapper;
import com.kuang.reggie.service.DishFlavorService;
import com.kuang.reggie.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
