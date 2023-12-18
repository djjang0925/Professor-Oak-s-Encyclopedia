package com.poke.oak.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "com.poke.oak.**.mapper" })
public class DBConfiguration {
}
