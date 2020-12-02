package com.atguigu.model;

import lombok.Data;

/**
 * @author lixw
 * @create 2020-11-28 16:45
 */
@Data
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer stock;
    private Integer sales;
    private String imgpath;

    public Book() {
    }

    public Book(Integer id, String title, String author, Double price, Integer stock, Integer sales, String imgpath) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.imgpath = imgpath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }


}
