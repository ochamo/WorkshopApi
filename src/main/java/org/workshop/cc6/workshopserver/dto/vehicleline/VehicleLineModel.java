package org.workshop.cc6.workshopserver.dto.vehicleline;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.workshop.cc6.workshopserver.dto.brand.request.BrandModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLineModel {
    private Integer lineId;
    private BrandModel vehicleBrand;
    private String lineName;
    private Byte deleted;
}
