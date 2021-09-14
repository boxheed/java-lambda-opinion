package com.fizzpod.opinions.lambda;

import java.util.Arrays;

import org.gradle.api.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fizzpod.gradle.plugins.pater.GradleBuildFile;
import com.github.jengelman.gradle.plugins.shadow.transformers.PropertiesFileTransformer;

public class LambdaShadeGradleBuildFile implements GradleBuildFile {

    private static final Logger logger = LoggerFactory.getLogger(LambdaShadeGradleBuildFile.class);

    public static final String TRANSFORMER_EXT_PROPERTY = "springShadowTransformer";

    private static final String NAME = "com-fizzpod-opinion-java-lambda";

    public String getName() {
        return NAME;
    }

    public void apply(Project project) {
        logger.info("Applying Spring specific configuration to lambda");
        PropertiesFileTransformer transformer = new PropertiesFileTransformer();
        transformer.setPaths(Arrays.asList("META-INF/spring.factories"));
        transformer.setMergeStrategy("append");
        logger.info("Created " + transformer);
        logger.info("Setting transformer on property" + TRANSFORMER_EXT_PROPERTY);
        project.setProperty(TRANSFORMER_EXT_PROPERTY, transformer);
    }

}