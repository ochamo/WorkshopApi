package org.workshop.cc6.workshopserver.model;

import lombok.Builder;

import java.util.List;

@Builder
public class BillingModel {
    private int Billingid;
    private String clientEmail;
    private String ClientBillingName;
    private String clienteBillingId;
    private String deliveryAddress;
    private List<BillingItemModel> billingItemModels;
}
