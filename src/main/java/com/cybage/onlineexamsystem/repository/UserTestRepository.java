package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTestRepository extends JpaRepository<UserTest, Integer>
{
	public List<UserTest> findAllByUserId(int userId);
}
