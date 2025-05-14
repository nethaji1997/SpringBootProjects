package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.exceptions.NoProductFoundException;
import com.nt.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product findProductById(Integer pid) {
		if(pid==101)
		{
			return new Product("101", "shampoo", 109.12);
		}
		else
		{
			throw new NoProductFoundException("Product not found");
		}
	}

}
