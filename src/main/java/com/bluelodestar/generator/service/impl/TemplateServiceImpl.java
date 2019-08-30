package com.bluelodestar.generator.service.impl;

import com.bluelodestar.generator.service.TemplateService;
import com.bluelodestar.generator.util.PathUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class TemplateServiceImpl implements TemplateService {

    public String getTemplate(String templateName) {
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(PathUtil.getJAVA_TEMPLATE_PATH() + templateName));
            while (bufferedReader.ready()) {
                stringBuilder.append("\n");
                stringBuilder.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
