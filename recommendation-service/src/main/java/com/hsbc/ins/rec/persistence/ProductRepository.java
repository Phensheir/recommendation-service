package com.hsbc.ins.rec.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.ins.rec.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List <Product> findByTitleLike();
	
	List <Product> findByTitleContainingAndDescriptinContaining();
	
}
