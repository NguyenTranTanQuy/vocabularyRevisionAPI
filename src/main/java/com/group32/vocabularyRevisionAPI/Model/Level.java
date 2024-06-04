package com.group32.vocabularyRevisionAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Level {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long levelID;
    private String level_name;
    private int experience;

    @OneToMany(mappedBy = "level", cascade = CascadeType.MERGE)
    private List<DetailedLevel> detailedLevelList = new ArrayList<>();
}
