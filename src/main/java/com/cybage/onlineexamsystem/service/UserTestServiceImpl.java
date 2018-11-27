package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.model.UserTest;
import com.cybage.onlineexamsystem.repository.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTestServiceImpl implements UserTestService {
    @Autowired
    private UserTestRepository userTestRepository;

    @Override
    public List<UserTest> getAllTestByUserId(int userId) {
        return userTestRepository.findAllByUserId(userId);
    }
}
