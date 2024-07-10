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

import br.com.project.join.controller.form.CategoryForm;
import br.com.project.join.model.Category;
import br.com.project.join.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> categories() {
			List<Category> categories = categoryService.findAll();
			return categories;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable @Min(value = 1, message = "The field cannot be negative") Long id) {
		return ResponseEntity.ok(categoryService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Category> create(@RequestBody CategoryForm categoryForm) {
		return ResponseEntity.ok(categoryService.save(categoryForm));
	}
	
    @PutMapping("/edit/{id}")
    public ResponseEntity<Category> edit(@PathVariable @Min(value = 1, message = "The field cannot be negative") Long id,
                                           @RequestBody @Valid CategoryForm categoryForm) {
        Category category = this.categoryService.edit(id, categoryForm);
        return ResponseEntity.ok(category);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> delete(@PathVariable @Min(value = 1, message = "The field cannot be negative") Long id) {
        this.categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
