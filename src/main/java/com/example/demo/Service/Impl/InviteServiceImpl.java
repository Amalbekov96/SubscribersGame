package com.example.demo.Service.Impl;

import com.example.demo.Entity.Invites;
import com.example.demo.Repo.InviteRepo;
import com.example.demo.Service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InviteServiceImpl  implements InviteService {

    private InviteRepo inviteRepo;

    public InviteServiceImpl(InviteRepo inviteRepo) {
        this.inviteRepo = inviteRepo;
    }

    @Override
    public Invites create(Invites invite) {
        return inviteRepo.save(invite);
    }

    @Override
    public Invites findById(Long id) {
        return inviteRepo.findById(id).orElse(null);
    }

    @Override
    public Invites update(Invites invite) {
        return inviteRepo.save(invite);
    }

    @Override
    public void deleteById(Long id) {
        inviteRepo.deleteById(id);
    }

    @Override
    public List<Invites> findAll() {
        return inviteRepo.findAll();
    }
}
