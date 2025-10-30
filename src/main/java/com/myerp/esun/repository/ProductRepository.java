package com.myerp.esun.repository;

import com.myerp.esun.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Optional<ProductEntity> findByProductId(String productId);

    //檢查編號是否存在
    boolean existsByProductId(String productId);

}
