package com.demo.streamapi.controller;

import com.demo.streamapi.entity.Customer;
import com.demo.streamapi.entity.Order;
import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.service.OrderManagement;
import com.demo.streamapi.service.OrderManagementStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderManagement orderManagement;

    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/byCategory")
    public List<Order> getOrdersByProductCategory(@RequestParam String productCategory){
        return orderManagement.getOrdersByProductBelogToCategory(productCategory);
    }

    @GetMapping("/recent")
    public List<Order> getRecentOrders(@RequestParam int limit){
        return orderManagement.getRecentOrders(limit);
    }

    @GetMapping("/salesByMonth")
    public Double getOrderSalesAmountByMonth(@RequestParam LocalDate salesMonth){
        return orderManagement.getOrderSalesAmountByMonth(salesMonth);
    }

    @GetMapping("/avgOrderPaymentByDay")
    public Double getAvgOrderPaymentByDay(@RequestParam LocalDate salesDay){
        return orderManagement.getAvgOrderPaymentByDay(salesDay).orElse(0);
    }

    @GetMapping("/productCount")
    public Map<Long,Integer>  getProductCountByOrder(){
        return orderManagement.getProductCountByOrder();
    }

    @GetMapping("/byCustomer")
    public Map<Customer, List<Order>> getOrdersByCustomers(){
        return orderManagement.getOrdersByCustomer();
    }

    @GetMapping("withOrderTotal")
    public Map<Order,Double> getOrderWithTotalPrice(){
        return orderManagement.getOrderWithTotalPrice();
    }



}
