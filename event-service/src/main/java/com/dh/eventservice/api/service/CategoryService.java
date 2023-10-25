package com.dh.eventservice.api.service;

import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;
public interface CategoryService {

    List<Category> getListByCategory(String category);

    Set<CategoryDto> getAllCategories();

    CategoryDto save(Category category);

    CategoryDto delete(Integer idCategory);

    CategoryDto findById(Integer idCategory);

    ResponseEntity update(CategoryDto categoryDto);
}
