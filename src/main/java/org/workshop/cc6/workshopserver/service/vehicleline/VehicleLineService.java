package org.workshop.cc6.workshopserver.service.vehicleline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.repository.VehicleBrandRepository;
import org.workshop.cc6.workshopserver.data.repository.VehicleLineRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.mapper.VehicleLineMapper;
import org.workshop.cc6.workshopserver.dto.vehicleline.CreateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.vehicleline.UpdateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.vehicleline.VehicleLineModel;

@Service
public class VehicleLineService implements IVehicleLineService {
    private VehicleLineRepository repository;
    private VehicleBrandRepository brandRepository;
    private VehicleLineMapper mapper;

    @Autowired
    public VehicleLineService(VehicleLineRepository repository, VehicleBrandRepository brandRepository, VehicleLineMapper mapper) {
        this.repository = repository;
        this.brandRepository = brandRepository;
        this.mapper = mapper;
    }

    @Override
    public BaseResponse create(CreateVehicleLineRequest req) {
        var entity = mapper.FromCreateReqToVehicleLine(req);
        var brand = brandRepository.findById(req.getBrandId());
        entity.setWorkshopVehicleBrand(brand.get());
        repository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse update(UpdateVehicleLineRequest req) {
        var entity = repository.findById(req.getLineId());
        var brand = brandRepository.findById(req.getBrandId());
        if (entity.isPresent() && brand.isPresent()) {
            var en = entity.get();
            var br = brand.get();
            en.setLineName(req.getLineName());
            en.setDeleted(req.getDeleted());
            en.setWorkshopVehicleBrand(br);
            repository.save(en);
        } else {
            throw new IllegalArgumentException("Not valid arguments");
        }
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<VehicleLineModel> getAll() {
        var entities = repository.findAll().stream().filter(p -> p.getDeleted() == 0);
        var items = entities.map(mapper::toVehicleLineModel).toList();
        return new GetListResponse<>(items);
    }
}
