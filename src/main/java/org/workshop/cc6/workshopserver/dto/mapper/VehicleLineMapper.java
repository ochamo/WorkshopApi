package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleLine;
import org.workshop.cc6.workshopserver.dto.vehicleline.VehicleLineModel;
import org.workshop.cc6.workshopserver.dto.vehicleline.CreateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.vehicleline.UpdateVehicleLineRequest;

@Mapper(
        componentModel = "spring"
)
public interface VehicleLineMapper {
    WorkshopVehicleLine FromCreateReqToVehicleLine(CreateVehicleLineRequest dto);
    WorkshopVehicleLine FromUpdateReqToVehicleLine(UpdateVehicleLineRequest dto);

    VehicleLineModel toVehicleLineModel(WorkshopVehicleLine en);

}
