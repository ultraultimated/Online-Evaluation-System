package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ResponseService {

    void insertResponse(Response response);
}
