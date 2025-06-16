package com.example.productinventorysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productinventorysystem.model.Supplier;
import com.example.productinventorysystem.repository.SupplierRepository;

@Service
@Transactional
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<Supplier> getAllSuppliers(){
		return supplierRepository.findAll();
	}
	
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	public void removeSupplier(long l) {
		// TODO Auto-generated method stub
		
	}

	public Supplier getSupplierById(long l) {
		// TODO Auto-generated method stub
		return null;
	}


}
