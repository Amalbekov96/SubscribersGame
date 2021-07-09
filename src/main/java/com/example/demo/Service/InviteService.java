package com.example.demo.Service;


import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Invites;
import com.example.demo.Entity.Subscribers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InviteService {

    Invites create(Invites invite);
    Invites findById(Long id);
    Invites update(Invites invite);
    void deleteById(Long id);
    List<Invites> findAll();
    InviteDto sendInvite(InviteDto inviteDto);
    ResponseEntity<String> accept(Long sub_id);
    ResponseEntity<String> activate(SubscribeDto receiver);
}
