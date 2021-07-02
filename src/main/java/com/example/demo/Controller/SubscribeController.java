package com.example.demo.Controller;

import com.example.demo.Entity.Subscribers;
import com.example.demo.Service.SubscriberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscribes")
public class SubscribeController {

    private SubscriberService subscriberService;

    public SubscribeController(SubscriberService subscriberService) {
        super();
        this.subscriberService = subscriberService;
    }

    @GetMapping("/findById/{id}")
    public Subscribers findById(@PathVariable Long id){
        return  subscriberService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Subscribers> findAll(){
        System.out.println("Wine");
        return subscriberService.findAll();
    }

    @PostMapping("/save")
    public Subscribers save(@RequestBody Subscribers subscriber){ return subscriberService.create(subscriber); }

    @PutMapping("/update/{id}")
    public Subscribers update(@RequestBody Subscribers subscriber, @PathVariable Long id){
        subscriber.setId(id);
        return subscriberService.update(subscriber);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        subscriberService.deleteById(id);
    }

    @PostMapping("/invite")
    public void invite(@PathVariable Long id){

    }
}
