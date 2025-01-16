package com.laoer.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2025/1/1 16:54
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Skin {
    private Integer ProductID;
    @JsonProperty("Name")
    private String Name;
    private BigDecimal Price;
    private String ImagePath;
    private String Color;

    public Skin() {
    }

    public Skin(Integer productID, String name, BigDecimal price, String imagePath, String color) {
        ProductID = productID;
        Name = name;
        Price = price;
        ImagePath = imagePath;
        Color = color;
    }

    @Override
    public String toString() {
        return "Skin{" +
                "ProductID=" + ProductID +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", ImagePath='" + ImagePath + '\'' +
                ", Color='" + Color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skin skin = (Skin) o;
        return Objects.equals(ProductID, skin.ProductID) && Objects.equals(Name, skin.Name) && Objects.equals(Price, skin.Price) && Objects.equals(ImagePath, skin.ImagePath) && Objects.equals(Color, skin.Color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductID, Name, Price, ImagePath, Color);
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
