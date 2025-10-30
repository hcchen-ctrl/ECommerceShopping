package com.myerp.esun.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class ProductDto {
    @NotBlank(message = "ID不能為空")
    @Size(min = 3, max = 5, message = "長度必須在 3-5 個字元之間")
    private String productId;

    @NotBlank(message = "productName不能為空")
    @Size(min = 3, max = 50, message = "長度必須在 3-50個字元之間")
    private String productName;

    @NotNull(message = "價格不能為空")
    @Min(value = 0, message = "價格不能小於 0")
    private Integer price;

    @NotNull(message = "庫存量不能為空")
    @Min(value = 0, message = "庫存量不能小於 0")
    private Integer quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
