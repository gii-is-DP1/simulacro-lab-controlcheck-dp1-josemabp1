package org.springframework.samples.petclinic.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @Transactional(readOnly = true)
	public List<ProductType> findAllProductTypes() throws DataAccessException {
		return productRepo.findAllProductTypes();
	}
    
    public List<Product> getProductsCheaperThan(double price) {
        return null;
    }

    public ProductType getProductType(String typeName) {
        return productRepo.getProductType(typeName);
    }

    public Product save(Product p){
        return null;       
    }
    
    public List<Product> getProductsCheaperThan(Double price) {    	
    	return productRepo.findByPriceLessThan(price);
    }

    
}
