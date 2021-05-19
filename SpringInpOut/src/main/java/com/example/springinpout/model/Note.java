package com.example.springinpout.model;


import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
