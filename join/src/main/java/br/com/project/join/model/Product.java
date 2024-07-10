package br.com.project.join.model;

import java.util.Calendar;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Long idProduct;
	
	@Column(name = "date_update_product ")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateUpdateProduct;
	
    @Column(name = "name_product")
    private String nameProduct;
    
    @Column(name = "details_product")
    private String detailsProduct;
    
    @Column(name = "price_product")
    private Double priceProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    private Category category;

	public Product(String nameProduct, String detailsProduct, Double priceProduct, Category category) {
		this.nameProduct = nameProduct;
		this.detailsProduct = detailsProduct;
		this.priceProduct = priceProduct;
		this.category = category;
	}

	public Product() {
		super();
	}


	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Calendar getDateUpdateProduct() {
		return dateUpdateProduct;
	}

	public void setDateUpdateProduct(Calendar dateUpdateProduct) {
		this.dateUpdateProduct = dateUpdateProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDetailsProduct() {
		return detailsProduct;
	}

	public void setDetailsProduct(String detailsProduct) {
		this.detailsProduct = detailsProduct;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

    

}
