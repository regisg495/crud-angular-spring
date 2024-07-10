package br.com.project.join.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.join.controller.form.ProductForm;
import br.com.project.join.model.Category;
import br.com.project.join.model.Product;
import br.com.project.join.service.CategoryService;
import br.com.project.join.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Product> products() {
			List<Product> products = productService.findAll();
			return products;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable @Min(value = 1, message = "The field cannot be negative") Long id) {
		return ResponseEntity.ok(productService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Product> create(@RequestBody ProductForm productForm) {
		Category category = categoryService.findById(productForm.getIdCategory());
		productForm.setCategory(category);
		return ResponseEntity.ok(productService.save(productForm));
	}
	
    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> edit(@PathVariable @Min(value = 1, message = "The field cannot be negative") Long id,
                                           @RequestBody @Valid ProductForm productForm) {
        Product product = this.productService.edit(id, productForm);
        return ResponseEntity.ok(product);
    }
    
	
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable @Min(value = 1, message = "The field cannot be negative") Long id) {
        this.productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
	
}
