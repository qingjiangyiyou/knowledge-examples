package com.github.ly641921791.example.nacos.spring.cloud.config.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

//    @Value(value = "${useLocalCache:false}")
//    private String useLocalCache;

//    @NacosValue(value = "${useLocalCache:false}")
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private String useLocalCache;

    @RequestMapping("/get")
    public String get() {
        return useLocalCache;
    }

}
