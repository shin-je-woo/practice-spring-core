package shinjw.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import shinjw.core.common.MyLogger;

@Configuration
@ComponentScan(
        basePackages = "shinjw.core",
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyLogger.class)
        }
)
public class AutoAppConfig {

}
