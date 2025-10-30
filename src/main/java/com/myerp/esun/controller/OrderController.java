package com.myerp.esun.controller;

import com.myerp.esun.Service.OrderService;
import com.myerp.esun.dto.OrderDto;
import com.myerp.esun.dto.ResponseDto;
import com.myerp.esun.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //查詢所有訂單細節
    @GetMapping("/get-all")
    public ResponseDto getAllOrders() {
        ResponseDto response = new ResponseDto();
        try {
            List<OrderEntity> orders = orderService.findAll();

            response.setStatus("success");
            response.setMessage("成功取得訂單列表");
            response.setData(orders);

        } catch (Exception e) {
            response.setStatus("error");
            response.setMessage("取得訂單列表失敗：" + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    //下單
    @PostMapping("/order")
    public ResponseDto createOrder(@RequestBody List<OrderDto> orderList) {
        System.out.println(">>> 從前端接收到資料 <<<");

        ResponseDto response = new ResponseDto();
        try {
            String result = orderService.createOrder(orderList);

            response.setStatus("success");
            response.setMessage(result);
            response.setData(null);

        } catch (RuntimeException e) {
            response.setStatus("error");
            response.setMessage("下單失敗：" + e.getMessage());
            response.setData(null);
        }

        return response;
    }

}
