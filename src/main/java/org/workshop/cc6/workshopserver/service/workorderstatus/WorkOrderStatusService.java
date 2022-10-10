package org.workshop.cc6.workshopserver.service.workorderstatus;

import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.repository.OrderStatusRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.mapper.WorkOrderStatusMapper;
import org.workshop.cc6.workshopserver.dto.workorderstatus.CreateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.UpdateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.WorkOrderStatusModel;

@Service
public class WorkOrderStatusService implements IWorkOrderStatusService {

    private OrderStatusRepository repository;
    private WorkOrderStatusMapper mapper;

    public WorkOrderStatusService(OrderStatusRepository repository, WorkOrderStatusMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BaseResponse create(CreateWorkOrderStatusRequest dto) {
        var entity = mapper.createToEntity(dto);
        repository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse update(UpdateWorkOrderStatusRequest dto) {
        var entity = mapper.updateToEntity(dto);
        repository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<WorkOrderStatusModel> getAll() {
        var entities = repository.findAll().stream().filter(p -> p.getDeleted() == 0);
        var models = entities.map(mapper::toModel).toList();
        return new GetListResponse<>(models);
    }
}
