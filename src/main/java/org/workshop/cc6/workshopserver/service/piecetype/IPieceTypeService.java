package org.workshop.cc6.workshopserver.service.piecetype;

import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.piece.PieceTypeModel;

public interface IPieceTypeService {
    GetListResponse<PieceTypeModel> getAll();
}
