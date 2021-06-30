package com.example.demo.Entity;

import com.example.demo.Entity.Enums.InviteStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Invites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
     private Subscribers sender;
    
    @ManyToOne
    private Subscribers receiver;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(value = EnumType.STRING )
    private InviteStatus status;
}
