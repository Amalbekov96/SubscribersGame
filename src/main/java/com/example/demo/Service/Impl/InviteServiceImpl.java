package com.example.demo.Service.Impl;

import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Invites;
import com.example.demo.Exceptions.InviteReachedLimit;
import com.example.demo.Mapper.SubscriberMapper;
import com.example.demo.Repo.InviteRepo;
import com.example.demo.Service.InviteService;
import com.example.demo.Service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class InviteServiceImpl  implements InviteService {

    private SubscriberService subscriberService;
    private InviteRepo inviteRepo;
    private SubscriberMapper subscriberMapper;

    @Autowired
    public InviteServiceImpl(SubscriberService subscriberService, InviteRepo inviteRepo, SubscriberMapper subscriberMapper) {
        this.subscriberService = subscriberService;
        this.inviteRepo = inviteRepo;
        this.subscriberMapper = subscriberMapper;
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

    @Override
    public InviteDto sendInvite(InviteDto inviteDto) {

        inviteDto.setSender(subscriberService.getOrCreate(inviteDto.getSender()));
        inviteDto.setReceiver(subscriberService.getOrCreate(inviteDto.getReceiver()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);


        long count = inviteRepo.countAllBySenderAndStartDateAfter(
                subscriberMapper.toSubscriber(inviteDto.getSender()),
                calendar.getTime()
        ) ;


        if(count > 5){
            throw new InviteReachedLimit("Reached the limit of the invite");
        }

        return inviteDto;
        }


}
