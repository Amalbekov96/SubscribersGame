package com.example.demo.dto;

import com.example.demo.Entity.Enums.InviteStatus;
import com.example.demo.Entity.Subscribers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

public class InviteDto {

        private long id;

        @ManyToOne
        private Subscribers sender;

        @ManyToOne
        private Subscribers receiver;

        @CreationTimestamp
        @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
        @Column(name = "add_date")
        private Date startDate;

        @UpdateTimestamp
        @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
        @Column(name = "edit_date")
        private Date endDate;

        @Enumerated(value = EnumType.STRING )
        private InviteStatus status;

}
