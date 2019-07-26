package com.example.springmvcapp;

import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Orders> getOrder(String id)
    {
        return userRepository.findById(id);
    }

}
