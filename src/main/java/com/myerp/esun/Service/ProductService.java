package com.myerp.esun.Service;

import com.myerp.esun.dto.ProductDto;
import com.myerp.esun.entity.ProductEntity;
import com.myerp.esun.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    //新增商品
    public ProductEntity addProduct(ProductDto ProductDto){
        System.out.println(">>> 正在新增商品：" );
        ProductEntity product = new ProductEntity();
        product.setProductID(ProductDto.getProductID());
        product.setProductName(ProductDto.getProductName());
        product.setPrice(ProductDto.getPrice());
        product.setQuantity(ProductDto.getQuantity());

        return ProductRepository.save(product);
    }

    //檢查商品ID是否存在
    public boolean ProductExists(String ProductID){
        return ProductRepository.existsByProductID(ProductID);
    }
}
