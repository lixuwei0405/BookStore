package com.atguigu.dao;

import com.atguigu.model.orders.Orders;
import com.atguigu.model.orders.OrdersItem;

/**
 * @author lixw
 * @create 2020-12-04 19:17
 */
public interface OrdersDao {
    void addOrders(Orders orders);

    void saveOrdersItem(OrdersItem ordersItem);
}
