package com.heowc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
public class SpringCloudRibbonClientApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringCloudRibbonClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonClientApplication.class, args);
    }


    @Bean
    public ApplicationRunner runner(LoadBalancerClient loadBalancer, RestTemplateBuilder builder) {
        return args -> {
            RestTemplate restTemplate = builder.build();

            logger.info(restTemplate.getForObject(getUriByLoadBalancer(loadBalancer), String.class));
            logger.info(restTemplate.getForObject(getUriByLoadBalancer(loadBalancer), String.class));
            logger.info(restTemplate.getForObject(getUriByLoadBalancer(loadBalancer), String.class));
            logger.info(restTemplate.getForObject(getUriByLoadBalancer(loadBalancer), String.class));
            logger.info(restTemplate.getForObject(getUriByLoadBalancer(loadBalancer), String.class));
            logger.info(restTemplate.getForObject(getUriByLoadBalancer(loadBalancer), String.class));
            logger.info(restTemplate.getForObject(getUriByLoadBalancer(loadBalancer), String.class));
        };
    }

    private URI getUriByLoadBalancer(LoadBalancerClient loadBalancer) {
        ServiceInstance instance = loadBalancer.choose("stores");
        return URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
    }
}
