package org.workshop.cc6.workshopserver.service.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillingItemModel {
    private String billingItemName;
    private Integer quantity;
    private BigDecimal price;
}
