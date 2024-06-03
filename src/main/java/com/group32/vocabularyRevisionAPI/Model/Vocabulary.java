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
public class Vocabulary {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long vocabularyID;
    private String word;
    private String definition;

    @ManyToOne
    @JoinColumn(name="vocabularyListID")
    private VocabularyLists vocabularyLists;

    @OneToMany(mappedBy = "vocabulary")
    private List<UserProgress> userProgressList = new ArrayList<>();
}
