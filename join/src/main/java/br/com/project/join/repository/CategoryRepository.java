package br.com.project.join.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.join.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	public Boolean existsByNameCategory(String nameCategory);
	
	Page<Category> findAll(Pageable pageable);
	
	@Override
	List<Category> findAll();

	public Optional<Category> findByNameCategory(String nameCategory);
}
