package com.example.demo.Entity.Dto;

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
