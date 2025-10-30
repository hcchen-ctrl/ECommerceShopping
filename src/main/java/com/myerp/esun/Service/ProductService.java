package com.myerp.esun.Service;

import com.myerp.esun.dto.ProductDto;
import com.myerp.esun.entity.ProductEntity;
import com.myerp.esun.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //新增商品
    public ProductEntity addProduct(ProductDto dto) {

        ProductEntity product = new ProductEntity();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        System.out.println(">>> 正在新增商品：" );
        System.out.println("商品ID：" + product.getProductId());
        System.out.println("商品名稱：" + product.getProductName());
        System.out.println("庫存：" + product.getQuantity());
        System.out.println("價格：" + product.getPrice());


        if (productRepository.existsById(product.getProductId())) {
            throw new RuntimeException("商品代號已存在，請勿重複新增");
        }

        return productRepository.save(product);
    }

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }
}
