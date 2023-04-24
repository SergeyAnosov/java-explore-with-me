package ru.practicum.model.category.service;

import ru.practicum.model.category.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategoriesPagination(Integer from, Integer size);

    CategoryDto getCategoryById(Long id);
}
