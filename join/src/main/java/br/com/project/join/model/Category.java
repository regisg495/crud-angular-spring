package br.com.project.join.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private Long idCategory;
	
    @Column(name = "date_update_category ")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateUpdateCategory;

    @Column(name = "name_category")
    private String nameCategory;
    
    @Column(name = "details_category")
    private String detailsCategory;
    
    @JsonIgnoreProperties("category")
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

	public Category() {
		super();
	}

	public Category(String nameCategory, String detailsCategory) {
		this.nameCategory = nameCategory;
		this.detailsCategory = detailsCategory;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public Calendar getDateUpdateCategory() {
		return dateUpdateCategory;
	}

	public void setDateUpdateCategory(Calendar dateUpdateCategory) {
		this.dateUpdateCategory = dateUpdateCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDetailsCategory() {
		return detailsCategory;
	}

	public void setDetailsCategory(String detailsCategory) {
		this.detailsCategory = detailsCategory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
    
}
