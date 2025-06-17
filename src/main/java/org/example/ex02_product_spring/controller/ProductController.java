package org.example.ex02_product_spring.controller;

import org.springframework.ui.Model;
import org.example.ex02_product_spring.model.Product;
import org.example.ex02_product_spring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String homePage() {
        return "firstpage";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "secondpage";
    }

    @GetMapping("/detail/{productId}")
    public String detailPage(@PathVariable("productId") Integer productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "thirdpage";
    }

    @GetMapping("/search")
    public String showProduct(@RequestParam(value = "category", required = false) String category,
                              @RequestParam(value = "price", required = false) double price, Model model) {
        List<Product> products = productService.getProductByCategoryAndMaxPrice(category, price);
        model.addAttribute("products", products);
        return "thirdproduct";
    }
}
