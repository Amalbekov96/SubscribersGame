package com.example.demo.Mapper.Impl;

import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Invites;
import com.example.demo.Mapper.InviterMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class InviteMapperImpl implements InviterMapper {

    InviterMapper INVITER_MAPPER = Mappers.getMapper( InviterMapper.class );

    @Override
    public Invites toInvites(InviteDto inviteDto) {
        Invites invite = new Invites();
        return INVITER_MAPPER.toInvites(inviteDto);
    }

    @Override
    public InviteDto toInviteDto(Invites invite) {
        return INVITER_MAPPER.toInviteDto(invite);
    }
}
