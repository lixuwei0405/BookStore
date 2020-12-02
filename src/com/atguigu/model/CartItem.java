package com.atguigu.model;

import java.math.BigDecimal;

/**
 * @author lixw
 * @create 2020-12-02 18:08
 */
public class CartItem {
    private Integer bookNum;  //本书选择的数量

    private Double amount; //小计 = 图书数量 * 单价

    private Book book;

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }
    //获取小计
    public Double getAmount() {
        BigDecimal price = new BigDecimal(book.getPrice());
        BigDecimal c = new BigDecimal(bookNum+"");
        double amount = price.multiply(c).doubleValue();
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
