package com.example.demo.Service.Impl;

import com.example.demo.Entity.Subscribers;
import com.example.demo.Repo.SubscriberRepo;
import com.example.demo.Service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberRepo subscriberRepo;

    public SubscriberServiceImpl(SubscriberRepo subscriberRepo) {
        this.subscriberRepo = subscriberRepo;
    }

    @Override
    public Subscribers create(Subscribers subscriber) {
        return subscriberRepo.save(subscriber);
    }

    @Override
    public Subscribers findById(Long id) {
        return subscriberRepo.findById(id).orElse(null);
    }

    @Override
    public Subscribers update(Subscribers subscriber) {
        return subscriberRepo.save(subscriber);
    }

    @Override
    public void deleteById(Long id) {
        subscriberRepo.deleteById(id);
    }

    @Override
    public List<Subscribers> findAll() {
        return subscriberRepo.findAll();
    }
}
