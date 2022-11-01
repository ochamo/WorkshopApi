package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleModel;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.CreateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.UpdateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.VehicleModel;

@Mapper(
        componentModel = "spring"
)
public interface VehicleModelMapper {
    WorkshopVehicleModel createToEntity(CreateVehicleModelRequest dto);
    WorkshopVehicleModel updateToEntity(UpdateVehicleModelRequest dto);
    VehicleModel toVehicleModel(WorkshopVehicleModel enr);
}
