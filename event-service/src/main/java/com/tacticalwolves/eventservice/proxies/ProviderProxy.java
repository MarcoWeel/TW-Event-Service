package com.tacticalwolves.eventservice.proxies;

import com.tacticalwolves.eventservice.config.ClientConfiguration;
import com.tacticalwolves.eventservice.entity.Provider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "providers-service", url = "${microservice.providers.url}", configuration = {ClientConfiguration.class})
public interface ProviderProxy {

    @GetMapping(value = "/providers/{id}")
    public Provider getDetails(@PathVariable("id") String id);
}