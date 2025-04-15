package io.flexwiz.orp.sample.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // Utilise JMapper ou MapStruct pour plus de performance
    // https://www.baeldung.com/java-performance-mapping-frameworks
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
