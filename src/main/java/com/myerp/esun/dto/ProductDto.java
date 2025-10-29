package com.myerp.esun.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class ProductDto {
    @NotBlank(message = "ID不能為空")
    @Size(min = 3, max = 5, message = "長度必須在 3-5 個字元之間")
    private String productID;

    @NotBlank(message = "productName不能為空")
    @Size(min = 3, max = 50, message = "長度必須在 3-50個字元之間")
    private String productName;

    @NotBlank(message = "price不能為空")
    @Size(min = 3, max = 50, message = "長度必須在 3-50個字元之間")
    private String price;

    @NotBlank(message = "quantity不能為空")
    @Size(min = 3, max = 50, message = "長度必須在 3-50個字元之間")
    private String quantity;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
