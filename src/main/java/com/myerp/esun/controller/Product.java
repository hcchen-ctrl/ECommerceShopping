package com.myerp.esun.controller;

import com.myerp.esun.Service.OrderService;
import com.myerp.esun.Service.ProductService;
import com.myerp.esun.dto.OrderDto;
import com.myerp.esun.dto.ProductDto;
import com.myerp.esun.entity.OrderEntity;
import com.myerp.esun.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class Product {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    // 取得所有商品
    @GetMapping("/list")
    public List<ProductEntity> getAllProducts() {
        return productService.findAll();
    }

    // 新增商品（從 Vue 送來 JSON）
    @PostMapping("/add")
    public ProductEntity addProduct(@RequestBody ProductDto dto) {
        System.out.println(">>> 從前端接收到資料 <<<");
        System.out.println("商品ID：" + dto.getProductId());
        System.out.println("商品名稱：" + dto.getProductName());
        System.out.println("庫存：" + dto.getQuantity());
        System.out.println("價格：" + dto.getPrice());

        // 呼叫 Service 時傳真正的 Entity
        ProductEntity entity = new ProductEntity();
        entity.setProductId(dto.getProductId());
        entity.setProductName(dto.getProductName());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());

        return productService.addProduct(entity);
    }

    //下單
    @PostMapping("/order")
    public String createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    //看訂單明細
    @GetMapping("/orders")
    public List<OrderEntity> findAllOrders() {
        return orderService.findAllOrders();
    }

}
