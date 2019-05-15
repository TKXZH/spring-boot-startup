package com.liujin.springbootstartup.controller;

import com.liujin.springbootstartup.domain.Product;
import com.liujin.springbootstartup.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/product")
@Api("产品信息API")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation(value = "产品分页查询", notes = "注意分页大小")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public List<Product> getPagedProduct(@RequestParam Integer index, @RequestParam Integer size) {
        return productService.pagingQueryProduct(PageRequest.of(index, size)).getContent();
    }


    @GetMapping("/boolean")
    public boolean addProduct(Product product) {
        return productService.createProduct(product);
    }
}
