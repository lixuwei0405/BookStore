package com.atguigu.model;

import lombok.Data;

import java.util.List;

/**
 * @author lixw
 * @create 2020-11-30 16:38
 */
@Data
public class PageBean<T> {
    //当前页
    private Integer pageNo;
    //总记录数
    private Integer totalCount;
    //总页数
    private Integer totalPage;
    //每页显示的数量
    private Integer limit;
    //每页起始位置
    private Integer begin;

    //每页数据的集合
    private List<T> list;

}
