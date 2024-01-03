package org.yascode.structuringproject.domain.service.impl;

import org.springframework.stereotype.Service;
import org.yascode.structuringproject.domain.model.Category;
import org.yascode.structuringproject.domain.service.ICategoryService;
import org.yascode.structuringproject.infrastructure.persistence.CategoryRepository;
import org.yascode.structuringproject.web.converter.CategoryConverter;
import org.yascode.structuringproject.web.dto.CategoryDTO;

import java.util.List;

/**
 * Implementation of the ICategoryService interface for managing categories.
 */
@Service
public class CategoryService implements ICategoryService {

    /**
     * Repository for handling Category entities, providing data access operations.
     */
    private final CategoryRepository categoryRepository;

    /**
     * Constructor for CategoryService.
     *
     * @param categoryRepositoryA The repository for handling Category entities.
     */
    public CategoryService(final CategoryRepository categoryRepositoryA) {
        this.categoryRepository = categoryRepositoryA;
    }

    /**
     * Retrieves all categories.
     *
     * @return List of Category objects representing all categories.
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Retrieves a specific category by its ID.
     *
     * @param categoryId The ID of the category to retrieve.
     * @return Category object representing the specified category.
     * @throws UnsupportedOperationException as the method is not yet implemented.
     */
    @Override
    public Category getCategoryById(final Long categoryId) {
        throw new UnsupportedOperationException("This method is not yet implemented.");
    }

    /**
     * Creates a new category based on the provided CategoryDTO.
     *
     * @param categoryDTO The CategoryDTO containing information for creating the category.
     * @return CategoryDTO representing the created category.
     */
    @Override
    public CategoryDTO createCategory(final CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(CategoryConverter.convertToEntity(categoryDTO));
        return CategoryConverter.convertToDTO(category);
    }

    /**
     * Updates a category with the specified ID using the provided updated category information.
     *
     * @param categoryId      The ID of the category to update.
     * @param updatedCategory The updated Category object.
     * @throws UnsupportedOperationException as the method is not yet implemented.
     */
    @Override
    public void updateCategory(final Long categoryId,
                               final Category updatedCategory) {
        throw new UnsupportedOperationException("This method is not yet implemented.");
    }

    /**
     * Deletes a category with the specified ID.
     *
     * @param categoryId The ID of the category to delete.
     * @throws UnsupportedOperationException as the method is not yet implemented.
     */
    @Override
    public void deleteCategory(final Long categoryId) {
        throw new UnsupportedOperationException("This method is not yet implemented.");
    }
}
