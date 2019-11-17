package com.program.product.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.program.product.model.Product;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

}
