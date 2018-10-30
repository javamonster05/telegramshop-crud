package com.javamonster.spring.controller;

import com.javamonster.spring.model.Product;
import com.javamonster.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired(required = true)
    @Qualifier("productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("productList", productService.listProduct());
        return "product";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") int id, Model model){
        productService.removeProduct(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product p){
        if(p.getId() == 0){
            productService.addProduct(p);
        }else {
            productService.updateProduct(p);
        }
        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("id") int id,Model model){
        model.addAttribute("product", productService.getProdictById(id));
        model.addAttribute("productList", productService.listProduct());
        return "product";
    }
}
