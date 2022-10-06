package org.workshop.cc6.workshopserver.service.vehiclebrand;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateVehicleLineRequest;

public interface IVehicleBrandService {
    BaseResponse createVehicleBrand(CreateBrandRequest req);

    BaseResponse createVehicleLine(CreateVehicleLineRequest req);


}
