package com.atguigu.model;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author lixw
 * @create 2020-12-02 18:08
 */
public class Cart {
    //多个购物项
    //key 图书id  value cartItem
    private Map<String,CartItem> map = new HashMap<>();
    private Integer totalCount;
    private Double totalAmount;


    /**
     * 获取购物车列表
     * @return
     */
    public List<CartItem> getCartItems(){
        Collection<CartItem> values = map.values();
        List<CartItem> list = new ArrayList<>(values);
        return list;
    }

    /**
     * 添加图书到购物车中
     * @param book
     */
    public void addBookCart(Book book){
        CartItem cartItem = map.get(book.getId() + "");
        if(cartItem==null){
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setBookNum(1);
            map.put(book.getId()+"",cartItem);
        }else{
            Integer bookNum = cartItem.getBookNum()+1;
            cartItem.setBookNum(bookNum);
        }
    }

    /**
     * 删除某个购物选项
     * @param bookId
     */
    public void deleteCartItem(String bookId){
        map.remove(bookId);
    }

    /**
     * 清空购物车
     * @return
     */
    public void clearCart(){
        map.clear();
    }
    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    /**
     * 总数量
     * @return
     */
    public Integer getTotalCount() {
        Integer totalCount = 0;
        List<CartItem> cartItems = getCartItems();
        for (CartItem cartItem : cartItems) {
            totalCount+=cartItem.getBookNum();
        }
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    /**
     * 总金额
     * @return
     */
    public Double getTotalAmount() {
        BigDecimal totalAmount = new BigDecimal("0");
        List<CartItem> cartItems = getCartItems();
        for (CartItem cartItem : cartItems) {
            BigDecimal amount = new BigDecimal(cartItem.getAmount() + "");
            totalAmount = totalAmount.add(amount);
        }
        return totalAmount.doubleValue();
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
