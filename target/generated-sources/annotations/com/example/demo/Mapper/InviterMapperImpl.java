package com.example.demo.Mapper;

import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Invites;
import com.example.demo.Entity.Subscribers;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-09T00:18:26-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class InviterMapperImpl implements InviterMapper {

    @Override
    public Invites toInvites(InviteDto inviteDto) {
        if ( inviteDto == null ) {
            return null;
        }

        Invites invites = new Invites();

        invites.setId( inviteDto.getId() );
        invites.setSender( subscribeDtoToSubscribers( inviteDto.getSender() ) );
        invites.setReceiver( subscribeDtoToSubscribers( inviteDto.getReceiver() ) );
        invites.setStartDate( inviteDto.getStartDate() );
        invites.setEndDate( inviteDto.getEndDate() );
        invites.setStatus( inviteDto.getStatus() );

        return invites;
    }

    @Override
    public InviteDto toInviteDto(Invites invite) {
        if ( invite == null ) {
            return null;
        }

        InviteDto inviteDto = new InviteDto();

        inviteDto.setId( invite.getId() );
        inviteDto.setSender( subscribersToSubscribeDto( invite.getSender() ) );
        inviteDto.setReceiver( subscribersToSubscribeDto( invite.getReceiver() ) );
        inviteDto.setStartDate( invite.getStartDate() );
        inviteDto.setEndDate( invite.getEndDate() );
        inviteDto.setStatus( invite.getStatus() );

        return inviteDto;
    }

    protected Subscribers subscribeDtoToSubscribers(SubscribeDto subscribeDto) {
        if ( subscribeDto == null ) {
            return null;
        }

        Subscribers subscribers = new Subscribers();

        subscribers.setId( subscribeDto.getId() );
        subscribers.setPhone( subscribeDto.getPhone() );
        subscribers.setStatus( subscribeDto.getStatus() );
        subscribers.setEditDate( subscribeDto.getEditDate() );
        subscribers.setAddDate( subscribeDto.getAddDate() );

        return subscribers;
    }

    protected SubscribeDto subscribersToSubscribeDto(Subscribers subscribers) {
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
