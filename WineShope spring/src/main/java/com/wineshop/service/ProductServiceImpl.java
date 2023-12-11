package com.wineshop.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wineshop.exception.ResourceNotFoundException;
import com.wineshop.model.Category;
import com.wineshop.model.Product;
import com.wineshop.model.ProductPaging;
import com.wineshop.repository.ProductRepository;
import com.wineshop.serviceinterface.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		System.out.println("Product Add Succesfully " + product);
		product.setProductname(product.getProductname());
		product.setQuantity(product.getQuantity());
		product.setMrpPrice(product.getMrpPrice());
		product.setImage(product.getImage());
		product.setDescription(product.getDescription());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product, long productId) {

		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
		existingProduct.setProductname(product.getProductname());
		// existingProduct.setPrice(product.getPrice());
		existingProduct.setMrpPrice(product.getMrpPrice());
		//existingProduct.setImage(product.getImage());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		// existingProduct.setCartId(product.getCartId());
		productRepository.save(existingProduct);
		return existingProduct;

	}

	@Override
	public void deleteProduct(long productId) {
		productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "Id", productId));
		productRepository.deleteById(productId);

	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductByProductId(long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
	}

	@Override
	public List<Product> findByCategory(Category catgory) {
	
		return productRepository.findByCategory(catgory);
		// return productRepository.findById(productId).orElseThrow(()->new
		// ResourceNotFoundException("Product","Id",productId));
	}

	@Override
	public ProductPaging findByCategory(Category catgory, Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findByCategory(catgory, paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		if (pageResult.hasContent()) {
			pr.setProduct(pageResult.getContent());
		} else {
			pr.setProduct(new ArrayList<Product>());
		}
		return pr;
	}

	@Override
	public ProductPaging getAllProducts(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pageResult = productRepository.findAll(paging);
		ProductPaging pr = new ProductPaging();
		pr.setTotalProduct(pageResult.getTotalElements());
		System.out.println(">>>>>" + pageResult.getTotalPages());
		if (pageResult.hasContent()) {
			pr.setProduct(pageResult.getContent());
		} else {
			pr.setProduct(new ArrayList<Product>());
		}
		return pr;
	}
}