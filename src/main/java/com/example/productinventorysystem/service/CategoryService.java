package com.example.productinventorysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productinventorysystem.model.Category;
import com.example.productinventorysystem.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	public Category getCategoryById(long l) {
		// TODO Auto-generated method stub
		return null;
	}
	public void removeCategory(long l) {
		// TODO Auto-generated method stub
		
	}
	

}
