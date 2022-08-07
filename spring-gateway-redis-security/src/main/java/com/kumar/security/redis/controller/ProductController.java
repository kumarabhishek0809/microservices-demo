package com.kumar.security.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.security.redis.entity.Product;
import com.kumar.security.redis.respository.ProductDao;

@RestController
@RequestMapping("/product")
public class ProductController {
	 @Autowired
	    private ProductDao dao;

	    @PostMapping
	    public Product save(@RequestBody Product product) {
	        return dao.save(product);
	    }

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return dao.findAll();
	    }

	    @GetMapping("/{id}")
	    public Product findProduct(@PathVariable int id) {
	        return dao.findProductById(id);
	    }
	    @DeleteMapping("/{id}")
	    public String remove(@PathVariable int id)   {
	    	return dao.deleteProduct(id);
		}

}
