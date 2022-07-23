package com.github.ly641921791.example.nacos.spring.cloud.discovery.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ly
 */
@RestController
public class HiController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @RequestMapping("/hi/{name}")
    public String sayHello(@PathVariable String name) {

        return restTemplate.getForObject("http://spring-cloud-discovery-provider/hello/" + name, String.class);
    }

}
