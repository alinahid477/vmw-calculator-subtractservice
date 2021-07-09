package com.calc.substractservice.services;

import org.springframework.stereotype.Service;

@Service
public class SubstractServiceImpl implements SubstractService {

    @Override
    public double subtract(double x, double y) {
        return x - y;
    }
    
}
