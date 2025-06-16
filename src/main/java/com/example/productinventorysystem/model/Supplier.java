package com.example.productinventorysystem.model;
import jakarta.persistence.*;
import java.util.*;
@Entity

public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long supplierid;
	private String suppliername;
	private String supplieraddress;
	private String suppliercontact;
	@OneToMany(mappedBy="supplier" ,cascade=CascadeType.ALL)
	private List<Product> products=new ArrayList<>();
	public Supplier(Long supplierid, String suppliername, String supplieraddress, String suppliercontact,
			List<Product> products) {
		super();
		this.supplierid = supplierid;
		this.suppliername = suppliername;
		this.supplieraddress = supplieraddress;
		this.suppliercontact = suppliercontact;
		this.products = products;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(Long supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	public String getSuppliercontact() {
		return suppliercontact;
	}
	public void setSuppliercontact(String suppliercontact) {
		this.suppliercontact = suppliercontact;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Supplier [supplierid=" + supplierid + ", suppliername=" + suppliername + ", supplieraddress="
				+ supplieraddress + ", suppliercontact=" + suppliercontact + ", products=" + products + "]";
	}
	
}
