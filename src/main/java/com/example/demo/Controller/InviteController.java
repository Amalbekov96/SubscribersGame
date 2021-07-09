package com.example.demo.Controller;

import com.example.demo.Entity.Dto.InviteDto;
import com.example.demo.Entity.Dto.SubscribeDto;
import com.example.demo.Entity.Invites;
import com.example.demo.Entity.Subscribers;
import com.example.demo.Service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invite")
public class InviteController {


    private InviteService inviteService;

    public InviteController(InviteService inviteService) {
        this.inviteService = inviteService;
    }

    @GetMapping("/find/{id}")
    public Invites findById(@PathVariable Long id){
        return  inviteService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Invites> findAll(){
        return inviteService.findAll();
    }

    @PostMapping("/save")
    public Invites save(@RequestBody Invites invite){ return inviteService.create(invite); }

    @PutMapping("/update/{id}")
    public Invites update(@RequestBody Invites invite, @PathVariable Long id){
        return inviteService.update(invite);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        inviteService.deleteById(id);
    }

    @PostMapping("/send")
    public InviteDto send(@RequestBody InviteDto inviteDto)
    {
            return inviteService.sendInvite(inviteDto);
    }

    @PutMapping("/accept/{id}")
    public ResponseEntity<String> accept(@PathVariable("id") Long id){
        return inviteService.accept(id);
    }

    @PutMapping("/activate")
    public ResponseEntity<String> accept(@RequestBody SubscribeDto receiberDto){
        return inviteService.activate(receiberDto);
    }

}
