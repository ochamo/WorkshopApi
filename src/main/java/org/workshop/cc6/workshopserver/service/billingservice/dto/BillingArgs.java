package org.workshop.cc6.workshopserver.service.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingArgs {
    private int billingId;
    private String clientEmail;
    private String clientBillingName;
    private String clientBillingId;
    private String deliveryAddress;
    private List<BillingItemModel> billingItemModels;
    private BigDecimal totalPurchase;
}
