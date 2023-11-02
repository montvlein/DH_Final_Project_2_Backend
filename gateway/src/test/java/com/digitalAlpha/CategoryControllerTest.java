package com.dh.eventservice;
import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.controller.CategoryController;
import com.dh.eventservice.api.service.CategoryService;
import com.dh.eventservice.domain.DTO.CategoryDto;
import com.dh.eventservice.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    public class CategoryControllerTest {

        @InjectMocks
        private CategoryController categoryController;

        @Mock
        private CategoryService categoryService;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testAddCategoria() {
            CategoryDto categoryDto = new CategoryDto();

            // Mock the service's behavior
            CategoryDto savedCategory= null;
            Mockito.when(categoryService.save(categoryDto)).thenReturn(savedCategory);

            ResponseEntity<?> response = categoryController.addCategoria(categoryDto);
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }


        @Test
        public void testFindCategory() throws ResourceNotFoundExceptions {
            int categoryId = 1;
            CategoryDto categoryDto = new CategoryDto();

            // Mock the service's behavior
            Mockito.when(categoryService.findById(categoryId)).thenReturn(categoryDto);

            CategoryDto response = categoryController.findCategory(categoryId);

            // Verificar que el objeto devuelto es igual al objeto categoryDto
            assertEquals(categoryDto, response);
        }


        @Test
        public void testListCategory() {
            Set<CategoryDto> categoryDtos = new HashSet<>();

            // Mock the service's behavior
            Mockito.when(categoryService.getAllCategories()).thenReturn(categoryDtos);

            ResponseEntity<Set<CategoryDto>> response = categoryController.listCategory();
            assertEquals(200, response.getStatusCodeValue());
            assertNotNull(response.getBody());
        }

        @Test
        public void testDeleteCategory() throws ResourceNotFoundExceptions {
            int categoryId = 1;

            // Realizar la acción que se va a probar
            ResponseEntity<HttpStatus> response = categoryController.deleteCategory(categoryId);

            // Verificar que el método delete del servicio se ha llamado con el ID correcto
            Mockito.verify(categoryService).delete(categoryId);

            // Verificar que la respuesta sea la esperada (código de estado 204 - NO_CONTENT)
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }



        @Test
        public void testUpdateCategory() throws ResourceNotFoundExceptions {
            CategoryDto categoriaDTO = new CategoryDto();
            categoriaDTO.setId(1);

            // Mock the service's behavior for findById
            Mockito.when(categoryService.findById(categoriaDTO.getId())).thenReturn(categoriaDTO);

            // Realizar la acción que se va a probar
            ResponseEntity<HttpStatus> response = categoryController.updateCategory(categoriaDTO);

            // Verificar que el método findById del servicio se ha llamado con el ID correcto
            Mockito.verify(categoryService).findById(categoriaDTO.getId());

            // Verificar que la respuesta sea la esperada (código de estado 200 - OK)
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }


    }


