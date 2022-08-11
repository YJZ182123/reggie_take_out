package com.kuang.reggie.controller;

import com.kuang.reggie.common.R;
import com.kuang.reggie.entity.Orders;
import com.kuang.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 用户下单
     * @param oders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(Orders oders){
        orderService.submit(oders);

        return null;
    }
}