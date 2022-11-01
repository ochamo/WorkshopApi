package org.workshop.cc6.workshopserver.service.vehiclepiece;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.piece.VehiclePieceModel;
import org.workshop.cc6.workshopserver.service.vehiclepiece.dto.CreatePieceRequest;
import org.workshop.cc6.workshopserver.service.vehiclepiece.dto.UpdatePieceRequest;

public interface IVehiclePieceService {
    public GetListResponse<VehiclePieceModel> getAll(Integer pieceModel);
    public BaseResponse create(CreatePieceRequest dto);
    public BaseResponse update(UpdatePieceRequest dto);
}
