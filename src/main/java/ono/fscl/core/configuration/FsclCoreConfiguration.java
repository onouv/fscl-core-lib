package ono.fscl.core.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:shadow-lib.yaml", factory = YamlPropertySourceFactory.class)
public class FsclCoreConfiguration {

}