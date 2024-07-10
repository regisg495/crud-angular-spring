package br.com.project.join.controller.form;

import br.com.project.join.model.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryForm {
	
    @Size(max = 200, message = "The name field exceeds the character limit")
    @NotNull(message = "The name field is required")
    @NotEmpty(message = "The name field is required")
	private String nameCategory;
    
    @Size(max = 65535, message = "The details field exceeds the character limits")
    private String detailsCategory;
    
    @NotNull(message = "The id field is required")
    private Long idCategory;

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

    public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	
	public Category convert() {
		return new Category(this.nameCategory, this.detailsCategory);
	}

}
