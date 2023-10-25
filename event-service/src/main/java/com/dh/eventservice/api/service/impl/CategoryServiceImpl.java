package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.CategoryService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    ObjectMapper mapper;

    @Override
    public List<Category> getListByDescription(String description) {
        return categoryRepository.findAllByDescription(description);
    }

    @Override
    public Set<CategoryDto> getAllCategories() {
        List<Category> categories=categoryRepository.findAll();
        Set<CategoryDto> categoryDto= new HashSet<>();
        for (Category c: categories) {
            categoryDto.add(mapper.convertValue(c,CategoryDto.class));
        }
        return categoryDto;

    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category=mapper.convertValue(categoryDto, Category.class);
        categoryRepository.save(category);
        logger.info("Se guardo la categoria "+ categoryDto );
        return categoryDto;
    }

    @Override
    public void delete(Integer idCategory) throws ResourceNotFoundExceptions{
        if (categoryRepository.findById((idCategory))==null){
            logger.error("No existe el elmento a eliminar");
            throw  new ResourceNotFoundExceptions("No existe el elmento a eliminar");
        }else {
            categoryRepository.deleteById(idCategory);
            logger.info("Se elimino correctamente la categoria con id: "+ idCategory);
        }
    }

    @Override
    public CategoryDto findById(Integer idCategory) throws ResourceNotFoundExceptions {
        Optional<Category> category= categoryRepository.findById((idCategory));
        CategoryDto categoryDto= null;
        if (category.isPresent()) {
            categoryDto = mapper.convertValue(category, CategoryDto.class);
        }else{
            throw new ResourceNotFoundExceptions("No existe la categoria buscada con id "+ idCategory);
        }
        return categoryDto;
    }

    @Override
    public ResponseEntity update(CategoryDto categoryDto) {

        return null;
    }
}
