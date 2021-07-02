package com.example.demo.Service;


import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Invites;

import java.util.List;

public interface InviteService {

    Invites create(Invites invite);
    Invites findById(Long id);
    Invites update(Invites invite);
    void deleteById(Long id);
    List<Invites> findAll();

    InviteDto sendInvite(InviteDto inviteDto);

}
