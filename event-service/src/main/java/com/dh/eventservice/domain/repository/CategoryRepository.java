package com.dh.eventservice.domain.repository;

import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.Event;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAllByCategory(String category);
}
