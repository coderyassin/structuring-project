package org.yascode.structuringproject.domain.service;

import org.yascode.structuringproject.domain.model.Category;
import org.yascode.structuringproject.web.dto.CategoryDTO;

import java.util.List;

/**
 * Service interface for managing categories.
 */
public interface ICategoryService {

    /**
     * Retrieves all categories.
     *
     * @return List of Category objects representing all categories.
     */
    List<Category> getAllCategories();

    /**
     * Retrieves a specific category by its ID.
     *
     * @param categoryId The ID of the category to retrieve.
     * @return Category object representing the specified category.
     */
    Category getCategoryById(Long categoryId);

    /**
     * Creates a new category based on the provided CategoryDTO.
     *
     * @param categoryDTO The CategoryDTO containing information for creating the category.
     * @return CategoryDTO representing the created category.
     */
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    /**
     * Updates a category with the specified ID using the provided updated category information.
     *
     * @param categoryId      The ID of the category to update.
     * @param updatedCategory The updated Category object.
     */
    void updateCategory(Long categoryId, Category updatedCategory);

    /**
     * Deletes a category with the specified ID.
     *
     * @param categoryId The ID of the category to delete.
     */
    void deleteCategory(Long categoryId);
}
