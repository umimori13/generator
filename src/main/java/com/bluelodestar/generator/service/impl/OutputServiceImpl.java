package com.bluelodestar.generator.service.impl;

import com.bluelodestar.generator.model.dto.PoDto;
import com.bluelodestar.generator.service.OutputService;
import com.bluelodestar.generator.util.PathUtil;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class OutputServiceImpl implements OutputService {
    public void outputFile(String result, PoDto poDto) {
        try {
            byte[] resultBytes = result.getBytes();
            OutputStream outputStream = new FileOutputStream(
                    PathUtil.getJAVA_RESULT_PATH() + poDto.getClassName() + ".java");
            outputStream.write(resultBytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
