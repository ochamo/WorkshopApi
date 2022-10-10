package org.workshop.cc6.workshopserver.dto.location.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode

public class LocationModel {
    private Integer locationId;
    private String locationName;
    private BigDecimal locationLatitude;
    private BigDecimal locationLongitude;
    private String locationAddress;
    private Byte deleted;
}
