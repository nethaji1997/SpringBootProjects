package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Product;
import com.nt.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value="/getProduct")
	public Product getProductDataById(@RequestParam String pid)
	{
		return productService.findProductById(Integer.parseInt(pid));
	}
}
