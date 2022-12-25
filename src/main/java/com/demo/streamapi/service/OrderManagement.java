package com.demo.streamapi.service;

import com.demo.streamapi.entity.Customer;
import com.demo.streamapi.entity.Order;
import com.demo.streamapi.entity.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

public interface OrderManagement {

    /*
    Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
    */
    public List<Product> getProductByCategoryAndPriceGreaterThan(String category, Double price);

    /*
    Exercise 2 — Obtain a list of order with products belong to category
    */
    public List<Order> getOrdersByProductBelogToCategory(String category);

    /*
    * Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
    */
    public List<Product> getProjductByCategoryWithDiscount(String category, int discountPercentage);

    /*
    * Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    */
    public List<Product> getProductsByCustomerOfTierBetweenDays(Integer CustomerTier, LocalDate startDay, LocalDate endDay);

    /*
    * Exercise 5 — Get the cheapest products of “Books” category
    * */
    public Optional<Product> getCheapestProductByCategory(String category);

    /*
    * Excersie 6 - Get the 3 most recent placed order
    * */
    List<Order> getRecentOrders(int limit);

    /*
    *Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021, log the order
    *   records to the console and then return its product list
    * */
    List<Product> getProductForDay(LocalDate day);

    /*
    * Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
    * */
    double getOrderSalesAmountByMonth(LocalDate salesMonth);

    /*
    *Exercise 9 — Calculate order average payment placed on 14-Mar-2021
    * */
    OptionalDouble getAvgOrderPaymentByDay(LocalDate salesDay);

    /*
    * Exercise 10 — Obtain a collection of statistic figures
    * (i.e. sum, average, max, min, count) for all products of category “Books”
    * */
    String getProductStatisticsByCategory(String category);

    /*
    * Exercise 11 — Obtain a data map with order id and order’s product count
    * */
    Map<Long,Integer>  getProductCountByOrder();

    /*
    * Exercise 12 — Produce a data map with order records grouped by customer
    * */
    Map<Customer, List<Order>> getOrdersByCustomer();

    /*
    * Exercise 13 — Produce a data map with order record and product total sum
    * */
    Map<Order, Double> getOrderWithTotalPrice();

    /*
    * Exercise 14 — Obtain a data map with list of product name by category
    * */
    Map<String, List<String>> getProductByCategory();

    /*
    * Exercise 15 — Get the most expensive product by category
    * */
    Map<String, Optional<Product>> getMostExpensiveProductByCategory();
}
