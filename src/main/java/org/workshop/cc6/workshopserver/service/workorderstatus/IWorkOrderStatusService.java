package org.workshop.cc6.workshopserver.service.workorderstatus;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.workorderstatus.CreateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.UpdateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.WorkOrderStatusModel;

public interface IWorkOrderStatusService {
    BaseResponse create(CreateWorkOrderStatusRequest dto);
    BaseResponse update(UpdateWorkOrderStatusRequest dto);
    GetListResponse<WorkOrderStatusModel> getAll();
}
