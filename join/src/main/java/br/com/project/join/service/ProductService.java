package br.com.project.join.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.project.join.controller.form.ProductForm;
import br.com.project.join.model.Category;
import br.com.project.join.model.Product;
import br.com.project.join.repository.CategoryRepository;
import br.com.project.join.repository.ProductRepository;
import br.com.project.join.util.exception.CategoryNameAlreadyExistsException;
import br.com.project.join.util.exception.FieldValueAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}
	
	public Page<Product> findAll(Pageable pageable) {
		return this.productRepository.findAll(pageable);
	}
	
    public Product findById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (!product.isPresent()) throw new EntityNotFoundException("Product doenst exists");
        return product.get();
    }

    @Transactional
	public Product save(ProductForm productForm) {
		Product product = productForm.convert();
		if(this.productRepository.existsByNameProduct(product.getNameProduct())) {
			throw new CategoryNameAlreadyExistsException("Name already exists in another product");
		}
		return this.productRepository.save(product);
	}
    
    @Transactional
    public Product edit(Long id, ProductForm productForm) {
    	Product product = this.findById(id);
        Optional<Product> productOptional = this.productRepository.findByNameProduct(productForm.getNameProduct());
        if (productOptional.isPresent() && productOptional.get().getIdProduct() != product.getIdProduct())
            throw new FieldValueAlreadyExistsException("There is already a product registered with this name: " + product.getNameProduct());
        Optional<Category> category = this.categoryRepository.findById(productForm.getIdCategory());
        if(category.isPresent()) {
        	product.setCategory(category.get());
        }
        product.setNameProduct(productForm.getNameProduct());
        product.setDetailsProduct(productForm.getDetailsProduct());
        product.setPriceProduct(productForm.getPriceProduct());
        return product;
    }
    
    @Transactional
    public void deleteById(Long id) {
        Product product = this.findById(id);
        this.productRepository.deleteById(product.getIdProduct());
    }
}
