package org.example.ex02_product_spring.service;

import org.example.ex02_product_spring.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final Map<Integer, Product> products;

    public ProductService() {

        products = new HashMap<>();

        Product productFirst = Product.builder()
                .id(1)
                .name("PS5")
                .category("Games")
                .price(500)
                .build();

        Product productSecond = Product.builder()
                .id(2)
                .name("T-shirt")
                .category("Clothes")
                .price(20)
                .build();

        Product productThird = Product.builder()
                .id(3)
                .name("Book")
                .category("Culture")
                .price(25)
                .build();

        this.products.put(productFirst.getId(), productFirst);
        this.products.put(productSecond.getId(), productSecond);
        this.products.put(productThird.getId(), productThird);
    }
    
    public List<Product> getAllProducts() {
        return this.products.values().stream().toList();
    }

    public Product getProductById(int id) {
        return this.products.get(id);
    }

    public List<Product> getProductByCategoryAndMaxPrice(String category, double price) {
        return this.products.values().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getPrice() <= price)
                .collect(Collectors.toList());
    }
}
