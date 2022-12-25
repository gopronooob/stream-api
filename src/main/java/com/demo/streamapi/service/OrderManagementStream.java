package com.demo.streamapi.service;

import com.demo.streamapi.entity.Customer;
import com.demo.streamapi.entity.Order;
import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderManagementStream implements OrderManagement{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;


    @Override
    public List<Product> getProductByCategoryAndPriceGreaterThan(String category, Double price) {
      return    productRepository.findAll()
                 .stream()
                 .filter(p-> p.getCategory().equalsIgnoreCase("Books"))
                 .filter(p->p.getPrice()>100)
                 .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersByProductBelogToCategory(String category) {
        return null;
    }

    @Override
    public List<Product> getProjductByCategoryWithDiscount(String category, int discountPercentage) {
        return null;
    }

    @Override
    public List<Product> getProductsByCustomerOfTierBetweenDays(Integer CustomerTier, LocalDate startDay, LocalDate endDay) {
        return null;
    }

    @Override
    public Optional<Product> getCheapestProductByCategory(String category) {
        return Optional.empty();
    }

    @Override
    public List<Order> getRecentOrders(int limit) {
        return null;
    }

    @Override
    public List<Product> getProductForDay(LocalDate day) {
        return null;
    }

    @Override
    public double getOrderSalesAmountByMonth(LocalDate salesMonth) {
        return 0;
    }

    @Override
    public OptionalDouble getAvgOrderPaymentByDay(LocalDate salesDay) {
        return null;
    }

    @Override
    public String getProductStatisticsByCategory(String category) {
        return null;
    }

    @Override
    public Map<Long, Integer> getProductCountByOrder() {
        return null;
    }

    @Override
    public Map<Customer, List<Order>> getOrdersByCustomer() {
        return null;
    }

    @Override
    public Map<Order, Double> getOrderWithTotalPrice() {
        return null;
    }

    @Override
    public Map<String, List<String>> getProductByCategory() {
        return null;
    }

    @Override
    public Map<String, Optional<Product>> getMostExpensiveProductByCategory() {
        return null;
    }
}
