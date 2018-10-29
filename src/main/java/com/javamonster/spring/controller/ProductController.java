package com.javamonster.spring.controller;

import com.javamonster.spring.model.Product;
import com.javamonster.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    ProductService productService;

    @Autowired(required = true)
    @Qualifier("productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("products", productService.listProduct());
        return "product";
    }
}
