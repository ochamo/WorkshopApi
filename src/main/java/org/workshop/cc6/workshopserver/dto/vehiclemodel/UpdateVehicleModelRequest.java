package org.workshop.cc6.workshopserver.dto.vehiclemodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleModelRequest {
    private Integer modelLine;
    private Integer modelYear;
    private Integer modelId;
}