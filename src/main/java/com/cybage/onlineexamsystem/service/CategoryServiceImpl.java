package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public long countCategory() {
		return categoryRepository.count();
	}
}
