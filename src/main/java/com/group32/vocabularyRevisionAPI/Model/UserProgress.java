package com.group32.vocabularyRevisionAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProgress {
    @EmbeddedId
    private UserProgressKey ID;

    @ManyToOne
    @MapsId("username")
    private User user;

    @ManyToOne
    @MapsId("vocabularyID")
    private Vocabulary vocabulary;

    private int correct_attempts;
    private int incorrect_attempts;
    private Date last_attempt_date;
}
