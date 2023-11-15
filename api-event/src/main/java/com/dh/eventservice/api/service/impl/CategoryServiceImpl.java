package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.config.ModelMapperConfig;
import com.dh.eventservice.api.service.CategoryService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.Event;
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
    private ModelMapperConfig mapperM;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Category getCategoryByDescription(String description) {
        Category category = categoryRepository.findAllByDescription(description);
        return mapper.convertValue(category, Category.class);
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
        if (categoryRepository.findById(idCategory).isEmpty()){
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
    public String update(CategoryDto categoryDto) throws ResourceNotFoundExceptions{
        Optional<Category> category = categoryRepository.findById(categoryDto.getId());
        String response;
        if (category.isPresent()){
            categoryRepository.save(this.updateDb(category.get(), categoryDto));
            mapperM.getModelMapper().map(categoryDto, CategoryDto.class);
            response = "Successful update";
        } else {
            throw new ResourceNotFoundExceptions("Event could not be updated");
        }
        return response;
    }


    private Category updateDb(Category category, CategoryDto categoryDto){
        if(categoryDto.getUrlImage() != null) {
            category.setUrlImage(categoryDto.getUrlImage());
        }

        if(categoryDto.getDescription() != null){
            category.setDescription(categoryDto.getDescription());
        }

        return category;
    }
}
