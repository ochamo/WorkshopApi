package org.workshop.cc6.workshopserver.service.billingservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.service.billingservice.dto.BillingArgs;

@Service
public class BillingService {
    public BaseResponse createBill(BillingArgs args) {
        String uri = "http://localhost:8888/CreateBill";
        var restTemplate = new RestTemplate();
        var result = restTemplate.postForEntity(uri, args, Object.class);
        return new BaseResponse("1");
    }
}
