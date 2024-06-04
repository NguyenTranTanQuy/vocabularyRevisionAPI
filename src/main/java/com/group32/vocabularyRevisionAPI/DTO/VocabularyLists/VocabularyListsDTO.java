package com.group32.vocabularyRevisionAPI.DTO.VocabularyLists;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VocabularyListsDTO {
    private Long vocabularyListID;
    private String list_name;
    private String description;
}
