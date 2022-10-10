package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopOrderStatus;
import org.workshop.cc6.workshopserver.dto.workorderstatus.CreateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.UpdateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.WorkOrderStatusModel;

@Mapper(
        componentModel = "spring"
)
public interface WorkOrderStatusMapper {
    WorkshopOrderStatus createToEntity(CreateWorkOrderStatusRequest dto);
    WorkshopOrderStatus updateToEntity(UpdateWorkOrderStatusRequest dto);
    WorkOrderStatusModel toModel(WorkshopOrderStatus en);
}
