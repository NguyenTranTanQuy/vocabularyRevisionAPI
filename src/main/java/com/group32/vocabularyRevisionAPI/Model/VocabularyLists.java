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
public class VocabularyLists {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long vocabularyListID;
    private String list_name;
    private String description;

    @ManyToOne
    @JoinColumn(name="folderID")
    private Folder folder;

    @OneToMany(mappedBy = "vocabularyLists")
    private List<Vocabulary> vocabularyList = new ArrayList<>();
}
