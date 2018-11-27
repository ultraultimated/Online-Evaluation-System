package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.UserNotFoundException;
import com.cybage.onlineexamsystem.model.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResponseService {

    void insertResponse(Response response);

    List<Response> getAllReponse();

//    List<Response> getResponseByUserId(int userId) throws UserNotFoundException;
}
