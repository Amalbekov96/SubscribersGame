package com.example.demo.Mapper;

import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Subscribers;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-09T00:18:26-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class SubscriberMapperImpl implements SubscriberMapper {

    @Override
    public Subscribers toSubscriber(SubscribeDto subscriberDto) {
        if ( subscriberDto == null ) {
            return null;
        }

        Subscribers subscribers = new Subscribers();

        subscribers.setId( subscriberDto.getId() );
        subscribers.setPhone( subscriberDto.getPhone() );
        subscribers.setStatus( subscriberDto.getStatus() );
        subscribers.setEditDate( subscriberDto.getEditDate() );
        subscribers.setAddDate( subscriberDto.getAddDate() );

        return subscribers;
    }

    @Override
    public SubscribeDto toSubscriberDto(Subscribers subscribers) {
        if ( subscribers == null ) {
            return null;
        }

        SubscribeDto subscribeDto = new SubscribeDto();

        subscribeDto.setId( subscribers.getId() );
        subscribeDto.setPhone( subscribers.getPhone() );
        subscribeDto.setStatus( subscribers.getStatus() );
        subscribeDto.setEditDate( subscribers.getEditDate() );
        subscribeDto.setAddDate( subscribers.getAddDate() );

        return subscribeDto;
    }
}
