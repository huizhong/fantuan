package com.eeeya.fantuan.server.config;

import com.eeeya.fantuan.server.filter.SimpleCORSFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhonghui
 * @since 5/16/15.
 */
@Configuration
public class FilterConfig {
    @Autowired
    SimpleCORSFilter simpleCORSFilter;

}
