package com.soriano.srvCategoria.commons;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.soriano.srvCategoria")
@PropertySource("classpath:application.properties")
public class ConfiguradorSpring {
}
