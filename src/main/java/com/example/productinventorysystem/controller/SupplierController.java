package com.example.productinventorysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productinventorysystem.model.Category;
import com.example.productinventorysystem.model.Supplier;
import com.example.productinventorysystem.service.SupplierService;

@RestController
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	@GetMapping("/supplier/all")
	  public ResponseEntity<List<Supplier>> getAllSuppliers(){
		  return new ResponseEntity<>(supplierService.getAllSuppliers(),HttpStatus.OK);		  
	  }
	  @PostMapping("/supplier/save")
	  public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
		  return new ResponseEntity<>(supplierService.saveSupplier(supplier),HttpStatus.CREATED);
	  }

}
