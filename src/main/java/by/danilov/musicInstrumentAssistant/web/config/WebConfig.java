package by.danilov.musicInstrumentAssistant.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("by.danilov.musicInstrumentAssistant")
public class WebConfig implements WebMvcConfigurer {
}
