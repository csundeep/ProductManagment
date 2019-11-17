package com.program.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.product.model.Product;
import com.program.product.repoistory.ProductRespository;

@RequestMapping("/api/product")
@RestController
public class ProductController {
	@Autowired
	private ProductRespository productRespository;

	@GetMapping
	public List<Product> getProducts() throws Exception {
		return productRespository.findAll();
	}

	@GetMapping(path = "{id}")
	public Product getProduct(@PathVariable Integer id) throws Exception {
		return productRespository.getOne(id);
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) throws Exception {
		return productRespository.save(product);
	}

	@PutMapping(path = "{id}")
	public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) throws Exception {
		if (id == 0)
			throw new Exception("Pass id of product to update ");
		product.setId(id);
		return productRespository.save(product);
	}

	@DeleteMapping(path = "{id}")
	public void deleteProduct(@PathVariable Integer id) throws Exception {
		productRespository.deleteById(id);
	}

}
