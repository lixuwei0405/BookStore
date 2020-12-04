package com.atguigu.dao;

import com.atguigu.model.orders.Orders;
import com.atguigu.model.orders.OrdersItem;
import com.atguigu.utils.BaseDBUtils;

/**
 * @author lixw
 * @create 2020-12-04 19:17
 */
public class OrdersDaoImpl extends BaseDBUtils implements OrdersDao {
    @Override
    public void addOrders(Orders orders) {
        String sql = "insert into t_orders values(?,?,?,?,?)";
        Object[] params ={orders.getOid(),orders.getOrderstime(),orders.getTotalprice(),orders.getState(),orders.getUser().getUid()};
        update(sql,params);
    }

    @Override
    public void saveOrdersItem(OrdersItem ordersItem) {
        String sql= "insert into t_ordersitem values(?,?,?,?,?)";
        Object[] params ={ordersItem.getItemid(),ordersItem.getCount(),ordersItem.getAmount(),ordersItem.getBook().getId(),ordersItem.getOrders().getOid()};
        update(sql,params);
    }
}
