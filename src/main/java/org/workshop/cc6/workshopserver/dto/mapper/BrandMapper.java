package org.workshop.cc6.workshopserver.dto.mapper;

import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleBrand;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;

public interface BrandMapper {
    WorkshopVehicleBrand createBrandRequestToWorkshopVehicleBrand(CreateBrandRequest dto);
}
