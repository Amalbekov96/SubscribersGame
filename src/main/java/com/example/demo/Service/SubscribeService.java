package com.example.demo.Service;

import com.example.demo.Repo.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;

@Service
public class SubscribeService {


    @Autowired
    private SubscriberRepo subscriberRepo;
}
