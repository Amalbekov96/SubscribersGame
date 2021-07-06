package com.example.demo.Entity.Dto;

import com.example.demo.Entity.Enums.InviteStatus;
import lombok.Data;

import java.util.Date;


@Data
public class InviteDto {

    private long id;
    private SubscribeDto sender;
    private SubscribeDto receiver;
    private Date startDate;
    private Date endDate;
    private InviteStatus status;
}
