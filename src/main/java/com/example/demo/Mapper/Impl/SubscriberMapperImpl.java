package com.example.demo.Mapper.Impl;

import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Subscribers;
import com.example.demo.Mapper.SubscriberMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class SubscriberMapperImpl implements SubscriberMapper {

    SubscriberMapper SUBSCRIBER_MAPPER = Mappers.getMapper(SubscriberMapper.class);



    @Override
    public Subscribers toSubscriber(SubscribeDto subscriberDto) {
        Subscribers subscribers = new Subscribers();

        subscribers.setId(subscriberDto.getId());
        subscribers.setPhone(subscriberDto.getPhone());
        subscribers.setAddDate(subscriberDto.getAddDate());
        subscribers.setEditDate(subscriberDto.getEditDate());
        subscribers.setStatus(subscriberDto.getStatus());
        return subscribers;
    }

    @Override
    public SubscribeDto toSubscriberDto(Subscribers subscriber) {

        SubscribeDto subscriberDto = new SubscribeDto();

        subscriberDto.setId(subscriber.getId());
        subscriberDto.setPhone(subscriber.getPhone());
        subscriberDto.setAddDate(subscriber.getAddDate());
        subscriberDto.setEditDate(subscriber.getEditDate());
        subscriberDto.setStatus(subscriber.getStatus());

        return subscriberDto;
    }
}
