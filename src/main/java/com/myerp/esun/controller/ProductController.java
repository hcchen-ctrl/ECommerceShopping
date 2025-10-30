package com.myerp.esun.controller;

import com.myerp.esun.Service.ProductService;
import com.myerp.esun.dto.ProductDto;
import com.myerp.esun.dto.ResponseDto;
import com.myerp.esun.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //取得所有商品
    @GetMapping("/get-all")
    public ResponseDto getAllProducts() {
        ResponseDto response = new ResponseDto();

        try {
            List<ProductEntity> products = productService.findAll();

            response.setStatus("success");
            response.setMessage("成功取得商品列表");
            response.setData(products);

        } catch (Exception e) {
            response.setStatus("error");
            response.setMessage("取得商品列表失敗：" + e.getMessage());
            response.setData(null);
        }

        return response;
    }

    //新增商品
    @PostMapping("/add")
    public ResponseDto addProduct(@RequestBody ProductDto dto) {
        System.out.println(">>> 從前端接收到資料 <<<");

        ResponseDto response = new ResponseDto();

        try {
            // 呼叫 Service 新增商品
            ProductEntity entity = productService.addProduct(dto);

            response.setStatus("success");
            response.setMessage("商品新增成功");
            response.setData(entity);

        } catch (RuntimeException e) {
            response.setStatus("error");
            response.setMessage("新增失敗：" + e.getMessage());
            response.setData(null);
        }

        return response;
    }

}
