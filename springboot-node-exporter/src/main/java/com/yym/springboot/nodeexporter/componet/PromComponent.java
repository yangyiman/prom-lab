package com.yym.springboot.nodeexporter.componet;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class PromComponent {

    @Autowired
    private MeterRegistry registry;

    private Counter httpRequestsTotal ;
    @PostConstruct
    public void init(){
        System.out.println("---------------init------------------------------");
        httpRequestsTotal = registry.counter("http_requests_total","endpoint","status");
    }
/*
    private final Counter httpRequestsTotal = Counter.build()
            .name("http_requests_total")
            .help("Total number of http requests by response status code")
            .labelNames("endpoint", "status")
            .register();*/



    static List<String> endpoints = Arrays.asList("/login", "/regitry", "/hello", "/hi");

    static List<String> codes = Arrays.asList("200","500");

    final Random ran =new Random();
    /*for (int i = 0; i < nbRequests; i++) {
        String statusCode = this.giveStatusCode();
        String endpoint = this.giveEndpoint();
        this.httpRequestsTotal.labels(endpoint, statusCode).inc();
        int latency = this.giveLatency(statusCode);
        if (this.spikeMode) {
            latency *= 2;
        }
        this.httpRequestDurationMs.labels(endpoint, statusCode).observe(latency);
    }*/

    public void setTotal() {
        String endpoint = null;
        String code = null;
        for (int i = 0; i < 50; i++) {
            code = codes.get(ran.nextInt(codes.size()));
            endpoint = endpoints.get(ran.nextInt(endpoints.size()));
            this.httpRequestsTotal.increment();
        }
    }


}
