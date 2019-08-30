package com.bluelodestar.generator.controller;

import com.bluelodestar.generator.model.dto.PoDto;
import com.bluelodestar.generator.model.vo.DataVo;
import com.bluelodestar.generator.service.DealWithFileService;
import com.bluelodestar.generator.service.OutputService;
import com.bluelodestar.generator.service.TemplateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/generate")
public class GenerateController {
    @Resource
    private TemplateService templateService;
    @Resource
    private OutputService outputService;
    @Resource
    private DealWithFileService dealWithFileService;

    @RequestMapping(value = "/po")
    public String generate(@RequestBody DataVo dataVo) {
        String file = templateService.getTemplate("po.template");
        PoDto poDto = dataVo.getPoDto();
        String result = dealWithFileService.dealPoTemplate(file, poDto);
        outputService.outputFile(result, poDto);
        return result;
    }
}
