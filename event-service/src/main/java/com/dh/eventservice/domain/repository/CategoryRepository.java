package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // crear metodos si los necesitop
}

