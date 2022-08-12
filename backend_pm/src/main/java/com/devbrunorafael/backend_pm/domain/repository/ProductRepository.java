package com.devbrunorafael.backend_pm.domain.repository;

import com.devbrunorafael.backend_pm.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }
