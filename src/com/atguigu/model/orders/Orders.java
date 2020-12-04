package com.atguigu.model.orders;

import com.atguigu.model.User;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lixw
 * @create 2020-12-04 18:11
 */
@Data
@ToString
public class Orders {
    private String oid;

    private Date orderstime;

    private Double totalprice;

    private Integer state;

    private User user;

    //一个订单有多个订单项
    private List<OrdersItem> list = new ArrayList<>();



}
