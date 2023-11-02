package com.dh.eventservice.api.controller;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.service.CategoryService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Registrar Categoria
    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDTO) {
        categoryService.save(categoryDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    //Buscar por ID

    @GetMapping("/{id}")
    public CategoryDto findCategoryId(@PathVariable Integer id) throws ResourceNotFoundExceptions{
        return categoryService.findById(id);
    }

    //lista categorias por descreipcion
    @GetMapping("/desc/{description}")
    public Category getCategoryByDescription(@PathVariable String description) {
        return categoryService.getCategoryByDescription(description);
    }

    //Listar todas las categorias
    @GetMapping
    public ResponseEntity<Set<CategoryDto>> listCategory(){
        Set<CategoryDto> listarCategorias= categoryService.getAllCategories();
        return ResponseEntity.ok(listarCategorias);
    }

    //Eliminar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        categoryService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    //Actualizar Categoría
    @PutMapping
    public ResponseEntity<HttpStatus> updateCategory(@RequestBody CategoryDto categoriaDTO) throws ResourceNotFoundExceptions{

        if(categoriaDTO.getId() != null && categoryService.findById(categoriaDTO.getId())!= null){
            categoryService.update(categoriaDTO);
        }else{
            throw new ResourceNotFoundExceptions("No existe la categoria que se queire actualizar");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
