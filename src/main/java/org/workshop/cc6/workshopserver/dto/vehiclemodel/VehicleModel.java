package org.workshop.cc6.workshopserver.dto.vehiclemodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.workshop.cc6.workshopserver.dto.vehicleline.VehicleLineModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModel {
    private Integer modelId;
    private VehicleLineModel vehicleLineModel;
    private Integer modelYear;
    private Byte deleted;
}
