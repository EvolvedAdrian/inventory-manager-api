package com.evolvedadrian.inventory.repository;

import com.evolvedadrian.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
