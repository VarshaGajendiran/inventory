package com.example.productinventorysystem.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.productinventorysystem.model.Product;
import com.example.productinventorysystem.model.Supplier;
import com.example.productinventorysystem.repository.ProductRepository;
import com.example.productinventorysystem.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
@Mock
private ProductRepository productRepository;
@InjectMocks
private ProductService productService;

private Product product1;
private Product product2;
@BeforeEach
public void setUp(){
	product1=new Product();
	product1.setProductid(1L);
	product1.setProductname("lap");
	
	product2=new Product();
	product2.setProductid(2L);
	product2.setProductname("mouse");
}
@Test
public void testSaveProduct() {
	when(productRepository.save(product1)).thenReturn(product1);
	Product savedProduct=productService.saveProduct(product1);
	
	assertThat(savedProduct).isNotNull();
	assertThat(savedProduct.getProductname()).isEqualTo("lap");
	verify(productRepository,times(1)).save(product1);
}
@Test
public void testGetProduct() {
	when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
	Product foundProduct=productService.getProductById(1L);
	
	assertThat(foundProduct).isNotNull();
	assertThat(foundProduct.getProductname()).isEqualTo("lap");
	verify(productRepository,times(1)).findById(1L);
}
@Test
public void testGetAllProduct() {
	when(productRepository.findAll()).thenReturn(Arrays.asList(product1,product2));
	List<Product> products=productService.getAllProducts();
	assertThat(products).hasSize(2);
	verify(productRepository,times(1)).findAll();	
}
@Test
public void testRemoveProduct() {
	doNothing().when(productRepository).deleteById(1L);
	productService.removeProduct(1L);
	verify(productRepository,times(1)).deleteById(1L);
	
}



}
