package org.workshop.cc6.workshopserver.service.piecestatus;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.piecestatus.CreatePieceStatusRequest;
import org.workshop.cc6.workshopserver.dto.piecestatus.PieceStatusModel;
import org.workshop.cc6.workshopserver.dto.piecestatus.UpdatePieceStatusRequest;

public interface IPieceStatusService {
    BaseResponse create(CreatePieceStatusRequest dto);
    BaseResponse update(UpdatePieceStatusRequest dto);
    GetListResponse<PieceStatusModel> getAll();
}
