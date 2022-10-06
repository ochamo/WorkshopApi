package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleBrand;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleLine;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleModel;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateVehicleModelRequest;

@Mapper(
        componentModel = "spring"
)
public interface BrandMapper {
    WorkshopVehicleBrand createBrandRequestToWorkshopVehicleBrand(CreateBrandRequest dto);
    WorkshopVehicleLine createVehicleLineRequestToWorkshopVehicleLine(CreateVehicleLineRequest dto);

    WorkshopVehicleModel createVehicleModelRequestToWorkshopVehicleModel(CreateVehicleModelRequest dto);
}
