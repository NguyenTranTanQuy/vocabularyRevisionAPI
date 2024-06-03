package com.group32.vocabularyRevisionAPI.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailedLevelKey implements Serializable {
    @Column(name="username")
    private String username;

    @Column(name="levelID")
    private Long levelID;
}
