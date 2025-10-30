package com.myerp.esun.repository;

import com.myerp.esun.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowProductList extends JpaRepository<ProductEntity,String> {
    List<ProductEntity> findByQuantityGreaterThan(int quantity);

    }
