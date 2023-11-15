package com.dh.eventservice.api.service;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;
public interface CategoryService {

    Category getCategoryByDescription(String description);

    Set<CategoryDto> getAllCategories();

    CategoryDto save(CategoryDto categoryDto);

    void delete(Integer idCategory) throws ResourceNotFoundExceptions;

    CategoryDto findById(Integer idCategory) throws ResourceNotFoundExceptions;

    String update(CategoryDto categoryDto) throws ResourceNotFoundExceptions;
}