package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer> {

}
