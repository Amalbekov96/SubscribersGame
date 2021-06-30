package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Invite")
public class InviteController {




    @PostMapping("/send")
    private String sendInvite(@RequestBody){

        return null;
    }

}
