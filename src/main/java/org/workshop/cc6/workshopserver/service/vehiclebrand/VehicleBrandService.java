package org.workshop.cc6.workshopserver.service.vehiclebrand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.repository.VehicleBrandRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.brand.request.BrandModel;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;
import org.workshop.cc6.workshopserver.dto.brand.request.UpdateBrandRequest;
import org.workshop.cc6.workshopserver.dto.mapper.BrandMapper;

@Service
public class VehicleBrandService implements IVehicleBrandService {
    private VehicleBrandRepository brandRepository;
    private BrandMapper mapper;

    @Autowired
    public VehicleBrandService(VehicleBrandRepository brandRepository,
                               BrandMapper mapper) {
        this.brandRepository = brandRepository;
        this.mapper = mapper;
    }

    @Override
    public BaseResponse createVehicleBrand(CreateBrandRequest req) {
        var entity = mapper.createBrandRequestToWorkshopVehicleBrand(req);
        brandRepository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse updateVehicleBrand(UpdateBrandRequest req) {
        var entity = brandRepository.findById(req.getId());
        if (entity.isPresent()) {
            var en = entity.get();
            en.setBrandName(req.getBrandName());
            en.setDeleted(req.getDeleted());
            brandRepository.save(en);
        } else {
            throw new IllegalArgumentException("brand not found");
        }
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<BrandModel> getBrands() {
        var entities = brandRepository.findAll().stream().filter(p -> p.getDeleted() == 0);
        var response = entities.map(mapper::toBrandModel).toList();
        return new GetListResponse<>(response);
    }
}
