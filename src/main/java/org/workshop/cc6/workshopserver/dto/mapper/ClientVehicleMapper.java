package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopClientVehicle;
import org.workshop.cc6.workshopserver.dto.clientvehicle.ClientVehicleModel;
import org.workshop.cc6.workshopserver.dto.clientvehicle.CreateClientVehicle;
import org.workshop.cc6.workshopserver.dto.clientvehicle.UpdateClientVehicle;

@Mapper(
        componentModel = "spring"
)
public interface ClientVehicleMapper {
    WorkshopClientVehicle createToEntity(CreateClientVehicle req);
    WorkshopClientVehicle updateToEntity(UpdateClientVehicle req);
    ClientVehicleModel toModel(WorkshopClientVehicle en);
}
