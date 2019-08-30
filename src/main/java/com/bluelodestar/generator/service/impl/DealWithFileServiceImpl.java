package com.bluelodestar.generator.service.impl;

import com.bluelodestar.generator.model.dto.PoDto;
import com.bluelodestar.generator.service.DealWithFileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DealWithFileServiceImpl implements DealWithFileService {
    private final int LENGTH_OF_TEXT_FOR_PROPERTIES = 17;
    private final int LENGTH_OF_END_FOR = 10;
    @Override
    public String dealPoTemplate(final String file, final PoDto poDto) {
        String fileSettled = file;
        fileSettled = settleClassName(fileSettled, poDto.getClassName());
        fileSettled = settleProperties(fileSettled, poDto.getVariablesNameTypes());
        return fileSettled;
    }

    private String settleProperties(String fileInput, ArrayList<HashMap<String, String>> variablesNameTypes) {
        String forReg = "\\{\\{forProperties}}\\D*?\\{\\{endFor}}";
        Pattern pattern = Pattern.compile(forReg);
        Matcher matcher = pattern.matcher(fileInput);
        String forProperties = "";
        while(matcher.find()) {
            String textGet = matcher.group();
            forProperties = textGet.substring(LENGTH_OF_TEXT_FOR_PROPERTIES, textGet.length() - LENGTH_OF_END_FOR);
        }

        String typeReg = "\\{\\{type}}";
        Pattern typePattern = Pattern.compile(typeReg);
        Matcher typeMatcher = typePattern.matcher(forProperties);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0,len = variablesNameTypes.size(); i < len; i++) {
            String typeResult = typeMatcher.replaceAll(variablesNameTypes.get(i).get("type")).toString();
            String variablesName = "\\{\\{variablesName}}";
            Pattern variablesNamePattern = Pattern.compile(variablesName);
            Matcher variablesNameMatcher = variablesNamePattern.matcher(typeResult);
            stringBuilder.append(variablesNameMatcher.replaceAll(variablesNameTypes.get(i).get("name")));
        }
        return matcher.replaceAll(stringBuilder.toString());
    }

    private String settleClassName(String fileInput, String className) {
        String classNameReg = "\\{\\{className}}";
        Pattern pattern = Pattern.compile(classNameReg);
        Matcher matcher = pattern.matcher(fileInput);
        return matcher.replaceAll(className);
    }
}
