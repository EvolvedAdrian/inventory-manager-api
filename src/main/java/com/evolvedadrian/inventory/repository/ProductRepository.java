package com.evolvedadrian.inventory.repository;

import com.evolvedadrian.inventory.entity.Category;
import com.evolvedadrian.inventory.entity.Product;
import com.evolvedadrian.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findBySku(String sku);

    List<Product> findByName(String name);

    List<Product> findByCategory(Category category);

    List<Product> findBySupplier(Supplier supplier);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
