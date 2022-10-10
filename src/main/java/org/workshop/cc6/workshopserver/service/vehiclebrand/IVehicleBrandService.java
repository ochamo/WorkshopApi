package org.workshop.cc6.workshopserver.service.vehiclebrand;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.brand.request.BrandModel;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;
import org.workshop.cc6.workshopserver.dto.brand.request.UpdateBrandRequest;

public interface IVehicleBrandService {
    BaseResponse createVehicleBrand(CreateBrandRequest req);
    BaseResponse updateVehicleBrand(UpdateBrandRequest req);

    GetListResponse<BrandModel> getBrands();

}
