package com.example.productinventorysystem.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productinventorysystem.model.Category;
import com.example.productinventorysystem.service.CategoryService;


 @RestController
 public class CategoryController {
  
  @Autowired 
  private CategoryService categoryService;
  
  @GetMapping("/category/all")
  public ResponseEntity<List<Category>> getAllCategories(){
	  return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);		  
  }
  @PostMapping("/category/save")
  public ResponseEntity<Category> createCategory(@RequestBody Category category){
	  return new ResponseEntity<>(categoryService.saveCategory(category),HttpStatus.CREATED);
  }
}
 