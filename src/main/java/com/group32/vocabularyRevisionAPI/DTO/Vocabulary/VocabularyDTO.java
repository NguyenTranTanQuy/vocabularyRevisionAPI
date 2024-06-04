package com.group32.vocabularyRevisionAPI.DTO.Vocabulary;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VocabularyDTO {
    private Long vocabularyID;
    private String word;
    private String definition;
}
