package com.group32.vocabularyRevisionAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private @Id String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    private Long experience;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Folder> folderList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<DetailedLevel> detailedLevelList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<UserProgress> userProgressList = new ArrayList<>();
}
