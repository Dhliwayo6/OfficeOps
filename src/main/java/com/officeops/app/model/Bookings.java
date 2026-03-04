package com.officeops.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "bookings")
@Entity
@Data
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime time;
    private String room;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User organizer;

    @OneToMany(mappedBy = "bookings", cascade = CascadeType.ALL)
    private List<Guest> guests = new ArrayList<>();

}
