package com.example.demo.Service;


import com.example.demo.Entity.Invites;
import com.example.demo.Entity.Subscribers;

import java.util.List;

public interface InviteService {

    Invites create(Invites invite);
    Invites findById(Long id);
    Invites update(Invites invite);
    void deleteById(Long id);
    List<Invites> findAll();

}
