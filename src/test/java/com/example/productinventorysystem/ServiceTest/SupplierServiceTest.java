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

import com.example.productinventorysystem.model.Category;
import com.example.productinventorysystem.model.Supplier;
import com.example.productinventorysystem.repository.SupplierRepository;
import com.example.productinventorysystem.service.SupplierService;

@ExtendWith(MockitoExtension.class)
public class SupplierServiceTest {
	@Mock
	private SupplierRepository supplierRepository;
	@InjectMocks
	private SupplierService supplierService;
	
	private Supplier supplier1;
	private Supplier supplier2;
	@BeforeEach
	public void setUp(){
		supplier1=new Supplier();
		supplier1.setSupplierid(1L);
		supplier1.setSuppliername("varr");
		
		supplier2=new Supplier();
		supplier2.setSupplierid(2L);
		supplier2.setSuppliername("sha");
		
	}
	@Test
	public void testSaveSupplier() {
		when(supplierRepository.save(supplier1)).thenReturn(supplier1);
		Supplier savedSupplier=supplierService.saveSupplier(supplier1);
		
		assertThat(savedSupplier).isNotNull();
		assertThat(savedSupplier.getSuppliername()).isEqualTo("varr");
		verify(supplierRepository,times(1)).save(supplier1);
	}
	@Test
	public void testGetCategory() {
		when(supplierRepository.findById(1L)).thenReturn(Optional.of(supplier1));
		Supplier foundSupplier=supplierService.getSupplierById(1L);
		
		assertThat(foundSupplier).isNotNull();
		assertThat(foundSupplier.getSuppliername()).isEqualTo("varr");
		verify(supplierRepository,times(1)).findById(1L);
	}
	@Test
	public void testGetAllSupplier() {
		when(supplierRepository.findAll()).thenReturn(Arrays.asList(supplier1,supplier2));
		List<Supplier> suppliers=supplierService.getAllSuppliers();
		assertThat(suppliers).hasSize(2);
		verify(supplierRepository,times(1)).findAll();	
	}
	@Test
	public void testRemoveSupplier() {
		doNothing().when(supplierRepository).deleteById(1L);
		supplierService.removeSupplier(1L);
		verify(supplierRepository,times(1)).deleteById(1L);
		
	}
	
	

}
