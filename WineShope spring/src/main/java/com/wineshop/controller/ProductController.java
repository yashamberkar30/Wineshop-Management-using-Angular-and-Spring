package com.wineshop.controller;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wineshop.model.Category;
import com.wineshop.model.Product;
import com.wineshop.model.ProductPaging;
import com.wineshop.serviceinterface.ProductService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

		@PostMapping("/add products")
		public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {

			return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
		}

		// to get all products
		@GetMapping
		public List<Product> getAllProducts() {
			return productService.getAllProducts();
		}

		@GetMapping("products/{productId}")
		public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId) {
			return new ResponseEntity<Product>(productService.getProductByProductId(productId), HttpStatus.OK);
		}

		@PutMapping("{productId}")
		public ResponseEntity<Product> updateProduct(@Valid @PathVariable("productId") long productId, @RequestBody Product product) {
			return new ResponseEntity<Product>(productService.updateProduct(product, productId), HttpStatus.OK);
		}

		@DeleteMapping("{productId}")
		public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") long productId) {
			productService.deleteProduct(productId);
			boolean flag = true;
			return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
		}
		
		
		@GetMapping("/{categoryId}")
		public List<Product> getAllProductsByCategory(@PathVariable("categoryId") int categoryId) {
			Category c = Category.valueOf(categoryId);
			return productService.findByCategory(c);
		}
		
		@GetMapping("/{categoryId}/{pageNo}/{pageSize}")
		public ProductPaging getAllProductsByCategory(@PathVariable("categoryId") int categoryId, @PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
			Category c = Category.valueOf(categoryId);
			return productService.findByCategory(c, pageNo, pageSize);
		}
		
		@GetMapping("/{pageNo}/{pageSize}")
		public ProductPaging getAllProducts(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
			return productService.getAllProducts(pageNo, pageSize);
		}

}