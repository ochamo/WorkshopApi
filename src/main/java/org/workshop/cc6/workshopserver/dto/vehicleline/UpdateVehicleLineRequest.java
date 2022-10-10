package org.workshop.cc6.workshopserver.dto.vehicleline;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVehicleLineRequest {
    private Integer brandId;
    private Integer lineId;
    private String lineName;
    private Byte deleted;
}
