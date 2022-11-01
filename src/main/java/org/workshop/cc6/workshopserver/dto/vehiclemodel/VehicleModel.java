package org.workshop.cc6.workshopserver.dto.vehiclemodel;

import lombok.*;
import org.workshop.cc6.workshopserver.dto.vehicleline.VehicleLineModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleModel {
    private Integer modelId;
    private VehicleLineModel vehicleLineModel;
    private String modelYear;
    private Byte deleted;
}
