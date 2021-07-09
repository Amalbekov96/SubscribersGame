package com.example.demo.Mapper;

import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Subscribers;
import org.mapstruct.Mapper;

@Mapper
public interface SubscriberMapper {

    Subscribers toSubscriber(SubscribeDto subscriberDto);
    SubscribeDto toSubscriberDto(Subscribers subscribers);
}
