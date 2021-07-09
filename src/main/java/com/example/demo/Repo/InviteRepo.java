package com.example.demo.Repo;

import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Invites;
import com.example.demo.Entity.Subscribers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InviteRepo extends JpaRepository<Invites, Long> {
    long countAllBySenderAndStartDateAfter(Subscribers subscribers, Date date);
    Invites findByEndDateAfter(Date date);
    Long countAllByReceiverAndSenderAndStartDateAfter(Subscribers sender, Subscribers receiver, Date date);
    Invites findByReceiverIdAndEndDateAfter(Long receiverId,Date date);
}
