package org.workshop.cc6.workshopserver.service.vehiclepiece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehiclePiece;
import org.workshop.cc6.workshopserver.data.repository.PieceTypeRepository;
import org.workshop.cc6.workshopserver.data.repository.VehicleModelRepository;
import org.workshop.cc6.workshopserver.data.repository.VehiclePieceRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.piece.VehiclePieceModel;
import org.workshop.cc6.workshopserver.dto.vehicleline.VehicleLineModel;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.VehicleModel;
import org.workshop.cc6.workshopserver.service.vehiclepiece.dto.CreatePieceRequest;
import org.workshop.cc6.workshopserver.service.vehiclepiece.dto.UpdatePieceRequest;

@Service
public class VehiclePieceService implements IVehiclePieceService {
    private final VehiclePieceRepository vehiclePieceRepository;
    private final VehicleModelRepository vehicleModelRepository;
    private final PieceTypeRepository pieceTypeRepository;

    @Autowired
    public VehiclePieceService(VehiclePieceRepository vehiclePieceRepository, VehicleModelRepository vehicleModelRepository, PieceTypeRepository pieceTypeRepository) {
        this.vehiclePieceRepository = vehiclePieceRepository;
        this.vehicleModelRepository = vehicleModelRepository;
        this.pieceTypeRepository = pieceTypeRepository;
    }

    @Override
    public GetListResponse<VehiclePieceModel> getAll(Integer pieceModel) {
        return new GetListResponse<>(vehiclePieceRepository.findAllByPieceModel(pieceModel)
                .stream().map(p -> {
                    var model = new VehiclePieceModel();
                    model.setPieceId(p.getPieceId());
                    var vehicleModel = new VehicleModel();
                    var vehicleModelEntity = p.getWorkshopPieceModel();
                    vehicleModel.setModelId(vehicleModelEntity.getModelId());
                    vehicleModel.setModelYear(vehicleModelEntity.getModelYear());
                    var lineModel = new VehicleLineModel();
                    var line = p.getWorkshopPieceModel().getVehicleLine();
                    lineModel.setLineName(line.getLineName());
                    lineModel.setLineId(line.getLineId());
                    vehicleModel.setVehicleLineModel(lineModel);
                    model.setPieceVehicleModel(vehicleModel);
                    return model;
                }).toList());
    }

    @Override
    public BaseResponse create(CreatePieceRequest dto) {
        var entity = new WorkshopVehiclePiece();
        var pieceType = pieceTypeRepository.findById(dto.getPieceType());
        var vehicleModel = vehicleModelRepository.findById(dto.getPieceModel());
        if (!pieceType.isPresent()) {
            throw new IllegalArgumentException(String.format("Piece with id  not found", dto
                    .getPieceType()));
        }

        if (!vehicleModel.isPresent()) {
            throw new IllegalArgumentException(String.format("Model with id %d not found", dto.getPieceModel()));
        }

        entity.setWorkshopPieceModel(vehicleModel.get());
        entity.setWorkshopPieceType(pieceType.get());

        vehiclePieceRepository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse update(UpdatePieceRequest dto) {
        var entity = vehiclePieceRepository.findById(dto.getPieceId());
        var pieceType = pieceTypeRepository.findById(dto.getPieceType());
        var vehicleModel = vehicleModelRepository.findById(dto.getPieceModel());
        if (!entity.isPresent()) {
            throw new IllegalArgumentException(String.format("Piece with id  not found", dto
                    .getPieceId()));
        }
        if (!pieceType.isPresent()) {
            throw new IllegalArgumentException(String.format("Piece with id  not found", dto
                    .getPieceType()));
        }

        if (!vehicleModel.isPresent()) {
            throw new IllegalArgumentException(String.format("Model with id %d not found", dto.getPieceModel()));
        }

        var en = entity.get();
        en.setWorkshopPieceModel(vehicleModel.get());
        en.setWorkshopPieceType(pieceType.get());

        vehiclePieceRepository.save(en);
        return new BaseResponse("1");
    }
}
