package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.UserNotFoundException;
import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.repository.ResponseRepository;
import com.cybage.onlineexamsystem.repository.UserRepository;
import org.modelmapper.internal.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertResponse(Response response) {
        responseRepository.save(response);
    }

    @Override
    public List<Response> getAllReponse() {
        return responseRepository.findAll();
    }

//    @Override
//    public List<Response> getResponseByUserId(int userId) throws UserNotFoundException {
//        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new).get;
//    }


}
