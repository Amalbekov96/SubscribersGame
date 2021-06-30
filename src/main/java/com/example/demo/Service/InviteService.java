package com.example.demo.Service;

import com.example.demo.Repo.InviteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviteService {

    @Autowired
    private InviteRepo inviteRepo;

}
