package org.workshop.cc6.workshopserver.service.vehiclebrand;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;

public interface IVehicleBrandService {
    BaseResponse createVehicleBrand(CreateBrandRequest req);
}
