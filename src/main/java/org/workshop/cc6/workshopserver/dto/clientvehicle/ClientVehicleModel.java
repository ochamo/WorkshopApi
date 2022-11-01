package org.workshop.cc6.workshopserver.dto.clientvehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.VehicleModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientVehicleModel {
    private Integer vehicleId;
    private VehicleModel vehicleModel;
    private String vehiclePlate;
    private Byte deleted;
}
