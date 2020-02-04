package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

public interface OrderService {
    // 1 通过前端url传过来秒杀活动id，下单接口内校验对应id是否属于对应商品目录且活动已开始
    // 2 直接在下单接口内判断对应商品是否存在秒杀活动，若存在进行中的则以秒杀价格下单
    // 第1种更好，原因是 1）同一个商品处于不同活动 秒杀入口确定 2）没有活动的商品也要校验 浪费
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException;


}
