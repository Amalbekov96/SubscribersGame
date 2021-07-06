package com.example.demo.Mapper;

import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Subscribers;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


public interface SubscriberMapper {

    Subscribers toSubscriber(SubscribeDto subscriberDto);
    SubscribeDto toSubscriberDto(Subscribers subscribers);



}
