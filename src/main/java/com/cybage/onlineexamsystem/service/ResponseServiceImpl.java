package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.repository.ResponseRepository;
import org.modelmapper.internal.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public void insertResponse(Response response) {
        responseRepository.save(response);
    }
}
