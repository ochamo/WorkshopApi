package org.workshop.cc6.workshopserver.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLocationRequest {
    private String locationName;
    private BigDecimal locationLatitude;
    private BigDecimal locationLongitude;
    private String locationAddr;
}
