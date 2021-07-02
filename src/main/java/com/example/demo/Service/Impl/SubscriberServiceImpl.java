package com.example.demo.Service.Impl;

import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Subscribers;
import com.example.demo.Exceptions.SubscriberNotFound;
import com.example.demo.Mapper.SubscriberMapper;
import com.example.demo.Repo.SubscriberRepo;
import com.example.demo.Service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.Date;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {


    private SubscriberRepo subscriberRepo;
    private SubscriberMapper subscriberMapper;

    public SubscriberServiceImpl(SubscriberRepo subscriberRepo, SubscriberMapper subscriberMapper) {
        this.subscriberRepo = subscriberRepo;
        this.subscriberMapper = subscriberMapper;
    }

    @Override
    public SubscribeDto getOrCreate(SubscribeDto subscribeDto){
        Subscribers subscriber = subscriberMapper.toSubscriber(subscribeDto);

        try {
            subscriber = subscriberRepo.findById(subscriber.getSub_id()).orElseThrow(() -> new SubscriberNotFound());
        } catch(SubscriberNotFound e){
            subscriber.setAddDate(new Date());
            subscriber.setEditDate(new Date());
            subscriber.setStatus(true);
        }
            return subscriberMapper.toSubscriberDto(subscriber);
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
