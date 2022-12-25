package com.demo.streamapi.controller;

import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.repository.ProductRepository;
import com.demo.streamapi.service.OrderManagement;
import com.demo.streamapi.service.OrderManagementStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderManagement orderManagement;

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Product> getAllProductByCategoryAndPriceGreaterThan(@PathVariable String category, @RequestParam double priceGreaterThan){
        return orderManagement.getProductByCategoryAndPriceGreaterThan(category, priceGreaterThan);
    }

    @GetMapping("/discount/{category}")
    public List<Product> getAllProductByCategoryWithDiscount(@PathVariable String category){
        return orderManagement.getProjductByCategoryWithDiscount(category,10);
    }

    @GetMapping("productOrderByCustomerTier/{customerTier}")
    public List<Product> getAllProductOrderedByCustomerTierBetweenDays(
            @PathVariable Integer customerTier,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDay,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDay){
        return orderManagement.getProductsByCustomerOfTierBetweenDays(customerTier, startDay, endDay);
    }

    @GetMapping("/cheapest")
    public Product getCheapestProductByCategory(@RequestParam String category){
        return orderManagement.getCheapestProductByCategory(category).get();
    }

    @GetMapping("/day")
    public List<Product> getProductForDay(@RequestParam LocalDate day){
        return orderManagement.getProductForDay(day);
    }

    @GetMapping("/statistics")
        public String getProductStatisticsByCategory(@RequestParam String category) {
        return orderManagement.getProductStatisticsByCategory(category);
    }

    @GetMapping("/byCategory")
    public Map<String,List<String>> getProductByCategory(){
        return orderManagement.getProductByCategory();
    }

    @GetMapping("/expensiveByCategory")
    public Map<String, Optional<Product>> getMostExpensiveProductByCategory(){
        return orderManagement.getMostExpensiveProductByCategory();
    }
}
