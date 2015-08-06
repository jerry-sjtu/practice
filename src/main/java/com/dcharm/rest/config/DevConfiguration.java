package com.dcharm.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by wangqiang on 2015/8/6.
 */
@Configuration("dev")
@EnableWebMvc
@ComponentScan("com.dcharm.rest")
public class DevConfiguration {

}
