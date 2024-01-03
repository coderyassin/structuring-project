package org.yascode.structuringproject.web.converter;

import org.modelmapper.ModelMapper;
import org.yascode.structuringproject.domain.model.Category;
import org.yascode.structuringproject.web.dto.CategoryDTO;

public class CategoryConverter {
    private static ModelMapper modelMapper = new ModelMapper();
    public static CategoryDTO convertToDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public static Category convertToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }
}
