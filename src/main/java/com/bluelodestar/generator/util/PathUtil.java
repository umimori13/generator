package com.bluelodestar.generator.util;

import lombok.Getter;

import java.io.File;

public final class PathUtil {
    private static final String SYSTEM_PATH = System.getProperty("user.dir") + File.separator;
    private static final String TEMPLATE_PATH = SYSTEM_PATH + "src" + File.separator
            + "main"+ File.separator + "resources"+ File.separator + "templates"+ File.separator;
    @Getter
    private static final String JAVA_TEMPLATE_PATH = TEMPLATE_PATH + "java" + File.separator;
    @Getter
    private static final String OTHER_TEMPLATE_PATH = TEMPLATE_PATH + "others" + File.separator;

    private static final String RESULT_PATH = SYSTEM_PATH + "src" + File.separator
            + "test"+ File.separator + "result"+ File.separator;
    @Getter
    private static final String JAVA_RESULT_PATH = RESULT_PATH + "java" + File.separator;
    @Getter
    private static final String OTHER_RESULT_PATH = RESULT_PATH + "others" + File.separator;
}
