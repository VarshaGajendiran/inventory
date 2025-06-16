package com.example.productinventorysystem.model;
import jakarta.persistence.*;
@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long productid;
private String productname;
private String productprice;
private String productdescription;
@ManyToOne
private Category category;

@ManyToOne
private Supplier supplier;

public Product(Long productid, String productname, String productprice, String productdescription, Category category,
		Supplier supplier) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.productprice = productprice;
	this.productdescription = productdescription;
	this.category = category;
	this.supplier = supplier;
}

public Product() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getProductid() {
	return productid;
}

public void setProductid(Long productid) {
	this.productid = productid;
}

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

public String getProductprice() {
	return productprice;
}

public void setProductprice(String productprice) {
	this.productprice = productprice;
}

public String getProductdescription() {
	return productdescription;
}

public void setProductdescription(String productdescription) {
	this.productdescription = productdescription;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public Supplier getSupplier() {
	return supplier;
}

public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

@Override
public String toString() {
	return "Product [productid=" + productid + ", productname=" + productname + ", productprice=" + productprice
			+ ", productdescription=" + productdescription + ", category=" + category + ", supplier=" + supplier + "]";
}

}
