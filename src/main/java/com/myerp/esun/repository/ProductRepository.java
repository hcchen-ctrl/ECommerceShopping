package com.myerp.esun.repository;

import com.myerp.esun.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    //根據ProductID查詢商品
    Optional<ProductEntity> findByProductID(String productID);

    //檢查編號是否存在
    boolean existsByProductID(String productID);


}
