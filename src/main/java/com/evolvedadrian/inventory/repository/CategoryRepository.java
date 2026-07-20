package com.evolvedadrian.inventory.repository;

import com.evolvedadrian.inventory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
