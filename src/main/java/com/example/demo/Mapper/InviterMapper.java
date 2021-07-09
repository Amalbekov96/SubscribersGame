package com.example.demo.Mapper;

import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Invites;
import org.mapstruct.Mapper;


@Mapper
public interface InviterMapper {
    Invites toInvites(InviteDto inviteDto);
    InviteDto toInviteDto(Invites invite);
}
