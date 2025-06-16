package com.example.productinventorysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productinventorysystem.model.Category;
import com.example.productinventorysystem.model.Product;
import com.example.productinventorysystem.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	public void removeProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	

}
