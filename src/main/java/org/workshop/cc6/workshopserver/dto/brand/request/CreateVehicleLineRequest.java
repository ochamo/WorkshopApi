package org.workshop.cc6.workshopserver.dto.brand.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehicleLineRequest {
    private Integer brandId;
    private String lineName;
}
