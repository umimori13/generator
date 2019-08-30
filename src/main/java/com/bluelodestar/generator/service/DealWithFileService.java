package com.bluelodestar.generator.service;

import com.bluelodestar.generator.model.dto.PoDto;

public interface DealWithFileService {
    String dealPoTemplate(String file, PoDto poDto);
}
