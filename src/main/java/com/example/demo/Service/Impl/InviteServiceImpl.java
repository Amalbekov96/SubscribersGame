package com.example.demo.Service.Impl;

import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Enums.InviteStatus;
import com.example.demo.Entity.Invites;
import com.example.demo.Exceptions.*;
import com.example.demo.Mapper.InviterMapper;
import com.example.demo.Mapper.SubscriberMapper;
import com.example.demo.Repo.InviteRepo;
import com.example.demo.Service.InviteService;
import com.example.demo.Service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class InviteServiceImpl  implements InviteService {

    private SubscriberService subscriberService;
    private InviteRepo inviteRepo;
    private SubscriberMapper subscriberMapper;
    private InviterMapper inviterMapper;

    public InviteServiceImpl(SubscriberService subscriberService, InviteRepo inviteRepo, SubscriberMapper subscriberMapper, InviterMapper inviterMapper) {
        this.subscriberService = subscriberService;
        this.inviteRepo = inviteRepo;
        this.subscriberMapper = subscriberMapper;
        this.inviterMapper = inviterMapper;
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

        SubscribeDto receiverDto = subscriberMapper.toSubscriberDto(subscriberService.findById(inviterMapper.toInvites(inviteDto).getReceiver().getId()));
        if(receiverDto.getStatus() == false){
            throw new SubscriberDisabledInviteOption("SubscrIber disabled inviting option.");
        }


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        long count = inviteRepo.countAllBySenderAndStartDateAfter(
                subscriberMapper.toSubscriber(inviteDto.getSender()),
                calendar.getTime()
        ) ;
        if(count > 5){
            throw new InviteReachedLimit("Reached the limit of the invite");
        }


        Calendar monthCa = Calendar.getInstance();
        monthCa.add(Calendar.MONTH, -1 );
        long coundInMonth = inviteRepo.countAllBySenderAndStartDateAfter(
                subscriberMapper.toSubscriber(inviteDto.getSender()),
                monthCa.getTime()
        );
        if(coundInMonth > 30){
            throw new InviteReachedLimit("Reached monthly limit 30 invites has been already made");
        }


        long sameSenderCount = inviteRepo.countAllByReceiverAndSenderAndStartDateAfter(
                subscriberMapper.toSubscriber(inviteDto.getReceiver()),
                subscriberMapper.toSubscriber(inviteDto.getSender()),
                calendar.getTime()
        );
        if(count > 1){
            throw new SameSenderLimit("You can invite same subscriber only once in a day.");
        }


        Calendar currentDate = Calendar.getInstance();
        Invites invite = inviteRepo.findByEndDateAfter(currentDate.getTime());

        if(invite != null){
            if(invite.getStatus().equals(InviteStatus.ACTIVE)){
                    throw new ReceiverAlreadyActivated("Receiver already activated an invite");
            } else {
                invite.setEndDate(new Date());
                inviteRepo.save(invite);
            }
        }
        inviteDto.setStatus(InviteStatus.REQUESTED);
        Calendar endlessYear = Calendar.getInstance();
        endlessYear.add(Calendar.YEAR, 999);
        inviteDto.setEndDate(endlessYear.getTime());
        return inviterMapper.toInviteDto(inviteRepo.save(inviterMapper.toInvites(inviteDto)));
    }


    @Override
    public ResponseEntity<String> accept(Long receiver_id) {
        InviteDto requestedDto = inviterMapper.toInviteDto(inviteRepo.findByReceiverIdAndEndDateAfter(receiver_id, new Date()));

        if(requestedDto.getStatus().equals(InviteStatus.REQUESTED)){
            requestedDto.setStatus(InviteStatus.ACCEPTED);
            inviteRepo.save(inviterMapper.toInvites(requestedDto));
            return new ResponseEntity<String> ("Requested invite was accepted", HttpStatus.OK);
        }
        return new ResponseEntity<String> ("Please check the status of Invite, because it is not REQUESTED!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> activate(SubscribeDto receiver) {

        InviteDto accInDto = inviterMapper.toInviteDto(inviteRepo.findByReceiverIdAndEndDateAfter(receiver.getId(), new Date()));

        if(accInDto.getStatus().equals(InviteStatus.ACCEPTED)){
            accInDto.setStatus(InviteStatus.ACTIVE);
            inviteRepo.save(inviterMapper.toInvites(accInDto));
            return new ResponseEntity<String>("Accepted request was activated", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Please check status of Invite, because it is not ACCEPTED!", HttpStatus.OK);
    }


}
