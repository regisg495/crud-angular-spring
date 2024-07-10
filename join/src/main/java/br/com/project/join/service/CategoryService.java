package br.com.project.join.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.project.join.controller.form.CategoryForm;
import br.com.project.join.model.Category;
import br.com.project.join.repository.CategoryRepository;
import br.com.project.join.util.exception.CategoryNameAlreadyExistsException;
import br.com.project.join.util.exception.FieldValueAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
	
	public Page<Category> findAll(Pageable pageable) {
		return this.categoryRepository.findAll(pageable);
	}
	
    public Category findById(Long id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        if (!category.isPresent()) throw new EntityNotFoundException("Category doenst exists");
        return category.get();
    }
	
	@Transactional
	public Category save(CategoryForm categoryForm) {
		Category category = categoryForm.convert();
		if(this.categoryRepository.existsByNameCategory(category.getNameCategory())) {
			throw new CategoryNameAlreadyExistsException("Name already exists in another category");
		}
		return this.categoryRepository.save(category);
	}
	
    @Transactional
    public Category edit(Long id, CategoryForm categoryForm) {
        Category category = this.findById(id);
        Optional<Category> categoryOptional = this.categoryRepository.findByNameCategory(categoryForm.getNameCategory());
        if (categoryOptional.isPresent() && categoryOptional.get().getIdCategory() != category.getIdCategory())
            throw new FieldValueAlreadyExistsException("There is already a group registered with this name: " + category.getNameCategory());
        category.setNameCategory(categoryForm.getNameCategory());
        category.setDetailsCategory(categoryForm.getDetailsCategory());
        return category;
    }
    
    @Transactional
    public void deleteById(Long id) {
        Category category = this.findById(id);
        this.categoryRepository.deleteById(category.getIdCategory());
    }

}
