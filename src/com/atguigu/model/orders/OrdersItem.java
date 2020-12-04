package com.atguigu.model.orders;

import com.atguigu.model.Book;
import lombok.Data;

/**
 * @author lixw
 * @create 2020-12-04 18:11
 */
@Data
public class OrdersItem {
    private String itemid;

    private Integer count;

    private Double amount;

    private Book book;

    private Orders orders;


}
