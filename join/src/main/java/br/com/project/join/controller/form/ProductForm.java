package br.com.project.join.controller.form;


import br.com.project.join.model.Category;
import br.com.project.join.model.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductForm {
	
    @Size(max = 200, message = "The name field exceeds the character limit")
    @NotNull(message = "The name field is required")
    @NotEmpty(message = "The name field is required")
	private String nameProduct;
    
    @Size(max = 65535, message = "The details field exceeds the character limits")
    private String detailsProduct;
    
    private Long idProduct;
    
    @NotNull(message = "The price field is required")
    private Double priceProduct;
    
    private Long idCategory;
    
    private Category category;
  

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

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product convert() {
		return new Product(this.nameProduct, this.detailsProduct, this.priceProduct, this.category);
	}
}
