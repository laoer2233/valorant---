package com.laoer.pojo;

import java.util.Objects;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2025/1/3 0:34
 */
public class sale {
    private Integer CartID;
    private Integer UserID;
    private Integer ProductID;
    private Integer Quantity;

    public sale() {
    }

    public sale(Integer cartID, Integer userID, Integer productID, Integer quantity) {
        CartID = cartID;
        UserID = userID;
        ProductID = productID;
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "sale{" +
                "CartID=" + CartID +
                ", UserID=" + UserID +
                ", ProductID=" + ProductID +
                ", Quantity=" + Quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        sale sale = (sale) o;
        return Objects.equals(CartID, sale.CartID) && Objects.equals(UserID, sale.UserID) && Objects.equals(ProductID, sale.ProductID) && Objects.equals(Quantity, sale.Quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CartID, UserID, ProductID, Quantity);
    }

    public Integer getCartID() {
        return CartID;
    }

    public void setCartID(Integer cartID) {
        CartID = cartID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
