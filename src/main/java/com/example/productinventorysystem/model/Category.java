package com.example.productinventorysystem.model;
import jakarta.persistence.*;
import java.util.*;
@Entity

public class Category {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long categoryid;
private String categoryname;

@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
private List<Product> products=new ArrayList<>();

public Category(Long categoryid, String categoryname, List<Product> products) {
	super();
	this.categoryid = categoryid;
	this.categoryname = categoryname;
	this.products = products;
}

public Category() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getCategoryid() {
	return categoryid;
}

public void setCategoryid(Long categoryid) {
	this.categoryid = categoryid;
}

public String getCategoryname() {
	return categoryname;
}

public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

@Override
public String toString() {
	return "Category [categoryid=" + categoryid + ", categoryname=" + categoryname + ", products=" + products + "]";
}

}
