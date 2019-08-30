package com.bluelodestar.generator.model.vo;

import com.bluelodestar.generator.model.dto.PoDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class DataVo implements Serializable {
    private PoDto poDto;
}
