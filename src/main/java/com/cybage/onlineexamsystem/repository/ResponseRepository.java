package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
}
