package br.com.project.join.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.join.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public Boolean existsByNameProduct(String nameProduct);
	
	Page<Product> findAll(Pageable pageable);
	
	List<Product> findAll();
	
	public Optional<Product> findByNameProduct(String nameProduct);

}
