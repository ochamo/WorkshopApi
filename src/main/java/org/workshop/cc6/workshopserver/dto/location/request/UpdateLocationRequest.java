package org.workshop.cc6.workshopserver.dto.location.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLocationRequest {
    private Integer id;
    private String locationName;
    private BigDecimal locationLat;
    private BigDecimal locationLong;
    private String locationAddr;
}
