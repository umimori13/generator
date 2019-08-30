package com.bluelodestar.generator.service;

import com.bluelodestar.generator.model.dto.PoDto;

public interface OutputService {
    void outputFile(String result, PoDto poDto);
}
