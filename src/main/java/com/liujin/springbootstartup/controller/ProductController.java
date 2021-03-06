package com.liujin.springbootstartup.controller;

import com.liujin.springbootstartup.domain.Product;
import com.liujin.springbootstartup.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public List<Product> getPagedProduct(@RequestParam Integer index, @RequestParam Integer size) {
        return productService.pagingQueryProduct(PageRequest.of(index, size)).getContent();
    }


    @GetMapping("/boolean")
    public boolean addProduct(Product product) {
        return productService.createProduct(product);
    }
}
