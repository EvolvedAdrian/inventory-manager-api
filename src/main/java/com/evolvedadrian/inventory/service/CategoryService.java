package com.evolvedadrian.inventory.service;

import com.evolvedadrian.inventory.entity.Category;
import com.evolvedadrian.inventory.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return this.categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        this.categoryRepository.delete(category);
    }
}
