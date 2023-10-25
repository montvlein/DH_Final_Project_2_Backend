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

    @Override
    public List<Category> getListByCategory(String category) {
        return null;
    }

    @Override
    public Set<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto save(Category category) {
        return null;
    }

    @Override
    public CategoryDto delete(Integer idCategory) {
        return null;
    }

    @Override
    public CategoryDto findById(Integer idCategory) {
        return null;
    }

    @Override
    public ResponseEntity update(CategoryDto categoryDto) {
        return null;
    }
/*
    @Autowired
    ObjectMapper mapper;

    public void save(CategoryDto categoryDto){
        Category category=mapper.convertValue(categoryDto, Category.class);
        categoryRepository.save(category);
        logger.info("Se guardo la categoria "+ categoryDto );
    }


    public CategoryDto find(Integer id) throws ResourceNotFoundExceptions {
        Optional<Category> category= categoryRepository.findById((id));
        CategoryDto categoryDto= null;
        if (category.isPresent()) {
            categoryDto = mapper.convertValue(category, CategoryDto.class);
        }else{
            throw new ResourceNotFoundExceptions("No existe la categoria buscada con id "+ id);
        }
        return categoryDto;
    }

    public Set<CategoryDto> findAll() {
        List<Category> categorias=categoryRepository.findAll();
        Set<CategoryDto> categoriaDTO= new HashSet<>();
        for (Category c: categorias) {
            categoriaDTO.add(mapper.convertValue(c,CategoryDto.class));
        }
        return categoriaDTO;
    }


    public void delete(Integer id) throws ResourceNotFoundExceptions{
        if (categoryRepository.findById((id))==null){
            throw  new ResourceNotFoundExceptions("No existe el elmento a eliminar");
        }else {
            categoryRepository.deleteById(id);
            logger.info("Se elimino correctamente la categoria con id: "+ id);
        }
    }

    public void actualizar(CategoryDto categoryDto) {
        Category categoria=mapper.convertValue(categoryDto, Category.class);
        categoryRepository.save(categoria);
        logger.info("Se modifico la categoria " + categoryDto);
    }*/
}
