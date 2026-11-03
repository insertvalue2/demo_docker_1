package com.tenco.demo_docker_1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsApiClient {

    public SmsApiClient(@Value("${SMS_API_KEY}") String apiKey,
                        @Value("${SMS_API_SECRET}") String apiSecret) {
        System.out.println("SMS 키 길이: " + apiKey.length());
    }
}
