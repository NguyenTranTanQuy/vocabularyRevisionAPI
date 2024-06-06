package com.group32.vocabularyRevisionAPI.Model.Statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LearnedVocabularyRanking {
    private String username;
    private String first_name;
    private String last_name;
    private int learned_vocabulary;

}
