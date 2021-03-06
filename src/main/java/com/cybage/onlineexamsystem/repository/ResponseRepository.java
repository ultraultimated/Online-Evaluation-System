package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
}
