package fr.seve.service;

import java.util.List;

import fr.seve.entities.Box;
import fr.seve.entities.Product;

public interface ProductService {
	
	List<Product> findAll();

	Product save(Product product);

	Product findById(Long id);

	void deleteById(Long Id);

}
