package com.example.demo.Repo;

import com.example.demo.Entity.Invites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepo extends JpaRepository<Invites, Long> {

}
