package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleBrand;
import org.workshop.cc6.workshopserver.dto.brand.request.BrandModel;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;
import org.workshop.cc6.workshopserver.dto.brand.request.UpdateBrandRequest;

@Mapper(
        componentModel = "spring"
)
public interface BrandMapper {
    WorkshopVehicleBrand createBrandRequestToWorkshopVehicleBrand(CreateBrandRequest dto);
    WorkshopVehicleBrand fromUpdateToWorkshopVehicleBrand(UpdateBrandRequest dto);

    BrandModel toBrandModel(WorkshopVehicleBrand en);

}
