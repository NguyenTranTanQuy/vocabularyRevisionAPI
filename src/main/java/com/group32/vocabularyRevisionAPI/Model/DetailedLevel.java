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
public class DetailedLevel {
    @EmbeddedId
    private DetailedLevelKey ID;

    @ManyToOne
    @MapsId("username")
    private User user;

    @ManyToOne
    @MapsId("levelID")
    private Level level;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
}
