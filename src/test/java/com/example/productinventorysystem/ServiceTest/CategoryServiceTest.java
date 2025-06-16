package com.example.productinventorysystem.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.productinventorysystem.model.Category;
import com.example.productinventorysystem.repository.CategoryRepository;
import com.example.productinventorysystem.service.CategoryService;



@ExtendWith(MockitoExtension.class)
@Transactional
public class CategoryServiceTest {
	@Mock
	private CategoryRepository categoryRepository;
	@InjectMocks
	private CategoryService categoryService;
	
	private Category category1;
	private Category category2;
	@BeforeEach
	public void SetUp() {
		category1=new Category();
		category1.setCategoryid(1L);
		category1.setCategoryname("phone");
		
		category2=new Category();
		category2.setCategoryid(2L);
		category2.setCategoryname("tab");
	}
	
	@Test
	public void testSaveCategory() {
		when(categoryRepository.save(category1)).thenReturn(category1);
		Category savedCategory=categoryService.saveCategory(category1);
		
		assertThat(savedCategory).isNotNull();
		assertThat(savedCategory.getCategoryname()).isEqualTo("phone");
		verify(categoryRepository,times(1)).save(category1);
	}
	@Test
	public void testGetCategory() {
		when(categoryRepository.findById(1L)).thenReturn(Optional.of(category1));
		Category foundCategory=categoryService.getCategoryById(1L);
		
		assertThat(foundCategory).isNotNull();
		assertThat(foundCategory.getCategoryname()).isEqualTo("phone");
		verify(categoryRepository,times(1)).findById(1L);
	}
	@Test
	public void testGetAllCategory() {
		when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1,category2));
		List<Category> categorys=categoryService.getAllCategories();
		assertThat(categorys).hasSize(2);
		verify(categoryRepository,times(1)).findAll();	
	}
	@Test
	public void testRemoveCategory() {
		doNothing().when(categoryRepository).deleteById(1L);
		categoryService.removeCategory(1L);
		verify(categoryRepository,times(1)).deleteById(1L);
		
	}

}
