package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopPieceStatus;
import org.workshop.cc6.workshopserver.dto.piecestatus.CreatePieceStatusRequest;
import org.workshop.cc6.workshopserver.dto.piecestatus.PieceStatusModel;
import org.workshop.cc6.workshopserver.dto.piecestatus.UpdatePieceStatusRequest;

@Mapper(
        componentModel = "spring"
)
public interface PieceStatusMapper {
    WorkshopPieceStatus toWorkshopPieceStatus(CreatePieceStatusRequest dto);
    WorkshopPieceStatus updateToEntity(UpdatePieceStatusRequest dto);
    PieceStatusModel toPieceStatusModel(WorkshopPieceStatus en);
}
