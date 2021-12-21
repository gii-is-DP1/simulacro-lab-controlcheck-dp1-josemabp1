package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product save(Product p);
    Product findByName(String name);
    @Query("SELECT pt FROM ProductType pt WHERE pt.name =:name")
    ProductType getProductType(String name);
    @Query("SELECT p FROM Product p WHERE p.price <?1")
    List<Product> findByPriceLessThan(Double price);
}
