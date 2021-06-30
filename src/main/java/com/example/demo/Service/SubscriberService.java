package com.example.demo.Service;

import com.example.demo.Entity.Subscribers;

import java.util.List;

public interface SubscriberService {

    Subscribers create(Subscribers subscriber);
    Subscribers findById(Long id);
    Subscribers update(Subscribers subscriber);
    void deleteById(Long id);
    List<Subscribers> findAll();

}
