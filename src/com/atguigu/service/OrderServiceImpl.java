package com.atguigu.service;

import com.atguigu.dao.OrdersDao;
import com.atguigu.dao.OrdersDaoImpl;
import com.atguigu.model.orders.Orders;
import com.atguigu.model.orders.OrdersItem;

import java.util.List;

/**
 * @author lixw
 * @create 2020-12-04 19:17
 */
public class OrderServiceImpl implements OrdersService {
    private OrdersDao ordersDao = new OrdersDaoImpl();
    //添加订单到数据库中
    @Override
    public void saveOrders(Orders orders) {
        //1.添加数据到订单表中
        ordersDao.addOrders(orders);

        //2.添加数据到订单项表
        List<OrdersItem> ordersItemList = orders.getList();
        for (OrdersItem ordersItem : ordersItemList) {
            ordersDao.saveOrdersItem(ordersItem);
        }
    }
}
