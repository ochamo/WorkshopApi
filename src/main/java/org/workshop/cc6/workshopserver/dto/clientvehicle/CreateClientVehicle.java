package org.workshop.cc6.workshopserver.dto.clientvehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientVehicle {
    private Integer clientId;
    private Integer vehicleModelId;
    private String vehiclePlate;
}
