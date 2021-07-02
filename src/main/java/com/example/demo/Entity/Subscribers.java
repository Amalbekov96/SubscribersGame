package com.example.demo.Entity;

import com.example.demo.Entity.Enums.InviteStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscribers")
public class Subscribers {

    @Id
    private long sub_id;
    private String phone;
    private Boolean status;

    @UpdateTimestamp
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    @Column(name = "edit_date")
    private Date editDate;

    @CreationTimestamp
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    @Column(name = "add_date")
    private Date addDate;


}
