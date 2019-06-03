package example.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import example.exception.product.ProductNotFoundException;
import example.rest.dao.ProductDAO;
import example.rest.model.Product;

@Service
public class ProductService {

	private final ProductDAO productDAO;

	ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public Product create(Product product) {
		return productDAO.save(product);
	}

	public Product update(Product productToUpdate) throws ProductNotFoundException {

		Product product = productDAO.findById(productToUpdate.getId());
		if (product == null)
			throw new ProductNotFoundException("Could not update. The product does not exist.");

		return productDAO.save(productToUpdate);
	}

	@SuppressWarnings("unchecked")
	public void delete(long id) {
		productDAO.deleteById(id);
	}

	
	public Product findById(long id) {
		return productDAO.findById(id);
	}

	@SuppressWarnings("rawtypes")
	public List getAll() {
		return productDAO.findAll();
	}
	
	public void deleteAll() {
		productDAO.deleteAll();
	}
	
	public long countProducts() {
		return productDAO.count();
	}
}
