package com.laoer.pojo;

import com.laoer.pojo.Skin;

import java.util.List;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2025/1/3 0:05
 */
public class CartWrapper {
    private List<Skin> cart;

    // Getter 和 Setter
    public List<Skin> getCart() {
        return cart;
    }

    public void setCart(List<Skin> cart) {
        this.cart = cart;
    }
}
