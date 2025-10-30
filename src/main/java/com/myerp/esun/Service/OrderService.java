package com.myerp.esun.Service;

import com.myerp.esun.dto.OrderDto;
import com.myerp.esun.entity.OrderEntity;
import com.myerp.esun.entity.ProductEntity;
import com.myerp.esun.repository.OrderRepository;
import com.myerp.esun.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public String createOrder(OrderDto orderDto) {
        ProductEntity product = productRepository.findByProductId(orderDto.getProductId()).orElse(null);
        if (product == null) {
            return "商品不存在";
        }

        if (product.getQuantity() < orderDto.getQuantity()) {
            return "庫存不足，下單失敗";
        }

        //新增訂單資料表
        OrderEntity order = new OrderEntity();
        order.setProductId(orderDto.getProductId());
        order.setQuantity(orderDto.getQuantity());
        order.setOrderId(orderDto.getOrderId());
        order.setStandPrice(product.getPrice());
        order.setItemPrice(product.getPrice() * orderDto.getQuantity());
        orderRepository.save(order);

        // 扣庫存
        product.setQuantity(product.getQuantity() - orderDto.getQuantity());
        productRepository.save(product);

        return "下單成功，商品：" + product.getProductName() +
                "，數量：" + orderDto.getQuantity();
    }

    public List<OrderEntity> findAllOrders(){
        return orderRepository.findAll();
    }
}
