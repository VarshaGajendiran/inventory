package com.example.productinventorysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productinventorysystem.exception.ResourceNotFoundException;
import com.example.productinventorysystem.model.Product;
import com.example.productinventorysystem.model.Supplier;
import com.example.productinventorysystem.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/product/all")
	  public ResponseEntity<List<Product>> getAllProducts(){
		  return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);		  
	  }
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Product product=productService.getProductById(id);
		if(product==null) {
			throw new ResourceNotFoundException("id not found:" +id);
			
		}
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	  @PostMapping("/product/save")
	  public ResponseEntity<Product> createProduct(@RequestBody Product product){
		  return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
	  }
	  @PutMapping("/product/{id}")
	  public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("id") Long id){
		  Product update1=productService.getProductById(id);
		  update1.setProductname(product.getProductname());
		  update1.setProductprice(product.getProductprice());
		  update1.setProductdescription(product.getProductdescription());
		  update1.setCategory(product.getCategory());
		  update1.setSupplier(product.getSupplier());
		  productService.saveProduct(update1);
		  
		  return new ResponseEntity<Product>(update1,HttpStatus.OK);
	  }
	  @DeleteMapping("/product/{id}")
	  public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		  productService.removeProduct(id);
		  return new ResponseEntity<>("Deleted product with id:" +id, HttpStatus.OK);
	  }
}
