package com.myerp.esun.Service;

import com.myerp.esun.dto.OrderDto;
import com.myerp.esun.entity.OrderEntity;
import com.myerp.esun.entity.OrderItemEntity;
import com.myerp.esun.entity.ProductEntity;
import com.myerp.esun.repository.OrderItemRepository;
import com.myerp.esun.repository.OrderRepository;
import com.myerp.esun.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional
    public String createOrder(List<OrderDto> orderList) {

        //建立訂單
        OrderEntity order = new OrderEntity();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(0);
        orderRepository.save(order);

        int total = 0;
        List<OrderItemEntity> orderItems = new ArrayList<>();

        //巡訪每一筆商品
        for (OrderDto dto : orderList) {
            ProductEntity product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new RuntimeException("商品不存在：" + dto.getProductId()));

            if (product.getQuantity() < dto.getQuantity()) {
                throw new RuntimeException("庫存不足：" + product.getProductName());
            }

            //成功扣庫存數量
            product.setQuantity(product.getQuantity() - dto.getQuantity());
            productRepository.save(product);

            //計算總計
            int subTotal = product.getPrice() * dto.getQuantity();

            //建立訂單資訊
            OrderItemEntity detail = new OrderItemEntity();
            detail.setOrder(order);
            detail.setProductId(product.getProductId());
            detail.setQuantity(dto.getQuantity());
            detail.setStandPrice(product.getPrice());
            detail.setItemPrice(subTotal);

            orderItems.add(detail);
            total += subTotal;
        }

        //儲存明細
        orderItemRepository.saveAll(orderItems);

        //更新訂單明細
        order.setTotalAmount(total);
        order.setOrderCode("MS" + order.getId()); //讓系統新增ID
        order.setOrderItems(orderItems);
        orderRepository.save(order);

        return "訂單建立成功！訂單編號：" + order.getId();
    }

    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }
}