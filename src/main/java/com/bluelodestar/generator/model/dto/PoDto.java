package com.bluelodestar.generator.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@Getter @Setter
@NoArgsConstructor
public class PoDto implements Serializable {
    private String className;
    private ArrayList<HashMap<String,String>> variablesNameTypes;
}
