package com.myerp.esun.Service;

import com.myerp.esun.entity.ProductEntity;
import com.myerp.esun.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    //新增商品
    public ProductEntity addProduct(ProductEntity product) {
        System.out.println(">>> 正在新增商品：" );
        System.out.println("商品ID：" + product.getProductId());
        System.out.println("商品名稱：" + product.getProductName());
        System.out.println("庫存：" + product.getQuantity());
        System.out.println("價格：" + product.getPrice());

        return ProductRepository.save(product);
    }

    //檢查商品ID是否存在
    public boolean ProductExists(String ProductID){
        return ProductRepository.existsByProductId(ProductID);
    }

    public List<ProductEntity> findAll(){
        return ProductRepository.findAll();
    }
}
