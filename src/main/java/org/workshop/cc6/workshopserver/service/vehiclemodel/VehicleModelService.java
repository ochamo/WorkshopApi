package org.workshop.cc6.workshopserver.service.vehiclemodel;

import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.repository.VehicleLineRepository;
import org.workshop.cc6.workshopserver.data.repository.VehicleModelRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.mapper.VehicleLineMapper;
import org.workshop.cc6.workshopserver.dto.mapper.VehicleModelMapper;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.CreateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.UpdateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.VehicleModel;

@Service
public class VehicleModelService implements IVehicleModelService {
    private final VehicleModelRepository vehicleModelRepository;
    private final VehicleLineRepository vehicleLineRepository;
    private final VehicleModelMapper vehicleModelMapper;
    private final VehicleLineMapper vehicleLineMapper;

    public VehicleModelService(VehicleModelRepository vehicleModelRepository, VehicleLineRepository vehicleLineRepository, VehicleModelMapper vehicleModelMapper, VehicleLineMapper vehicleLineMapper) {
        this.vehicleModelRepository = vehicleModelRepository;
        this.vehicleLineRepository = vehicleLineRepository;
        this.vehicleModelMapper = vehicleModelMapper;
        this.vehicleLineMapper = vehicleLineMapper;
    }

    @Override
    public BaseResponse create(CreateVehicleModelRequest req) {
        var entity = vehicleModelMapper.createToEntity(req);
        var line = vehicleLineRepository.findById(req.getModelLine());
        if (line.isPresent()) {
            entity.setVehicleLine(line.get());
        } else {
            return new BaseResponse("0");
        }
        vehicleModelRepository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse update(UpdateVehicleModelRequest req) {
        var entity = vehicleModelRepository.findById(req.getModelId())
                .orElseThrow(() -> new IllegalStateException(
                        String.format("model with %s not exists", req.getModelId())
                ));
        entity.setModelYear(req.getModelYear().toString());
        var modelLine = vehicleLineRepository.findById(req.getModelId())
                        .orElseThrow(() -> new IllegalStateException(
                                String.format("line with %s not exits", req.getModelId())
                        ));
        entity.setVehicleLine(modelLine);
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<VehicleModel> getAll() {
        var items = vehicleModelRepository.findAll()
                .stream().map(p -> {
                    return VehicleModel.builder()
                            .modelId(p.getModelId())
                            .vehicleLineModel(vehicleLineMapper.toVehicleLineModel(p.getVehicleLine()))
                            .modelYear(p.getModelYear())
                            .deleted(p.getDeleted())
                            .build();
                }).toList();

        return new GetListResponse<>(items);
    }
}
