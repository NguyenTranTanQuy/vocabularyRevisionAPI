package com.group32.vocabularyRevisionAPI.Controller.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor @Getter @Setter
public class ResponseData {
    private int status;
    private String message;
    private Object data;

    public ResponseData() {
        this.data = new ArrayList<>();
    }
}
