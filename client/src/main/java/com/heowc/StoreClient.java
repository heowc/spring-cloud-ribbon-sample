package com.heowc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("stores")
public interface StoreClient {

    @GetMapping("/")
    String getIndex();

}
