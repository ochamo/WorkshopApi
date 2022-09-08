package org.workshop.cc6.workshopserver.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class BillingItemModel {
    private String billingItemName;
    private int quantity;
    private BigDecimal price;
}
