package com.example.demo.Entity.Dto;

import com.example.demo.Entity.Enums.InviteStatus;
import lombok.Data;

import java.util.Date;

@Data
public class SubscribeDto {

    private long id;
    private String phone;
    private Boolean status;
    private Date editDate;
    private Date addDate;

}
