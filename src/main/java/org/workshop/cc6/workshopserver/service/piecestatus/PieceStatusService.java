package org.workshop.cc6.workshopserver.service.piecestatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.repository.PieceStatusRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.mapper.PieceStatusMapper;
import org.workshop.cc6.workshopserver.dto.piecestatus.CreatePieceStatusRequest;
import org.workshop.cc6.workshopserver.dto.piecestatus.PieceStatusModel;
import org.workshop.cc6.workshopserver.dto.piecestatus.UpdatePieceStatusRequest;

@Service
public class PieceStatusService implements IPieceStatusService {
    private PieceStatusRepository repository;
    private PieceStatusMapper mapper;

    @Autowired
    public PieceStatusService(PieceStatusRepository repository, PieceStatusMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BaseResponse create(CreatePieceStatusRequest dto) {
        var entity = mapper.toWorkshopPieceStatus(dto);
        repository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse update(UpdatePieceStatusRequest dto) {
        var entity = mapper.updateToEntity(dto);
        repository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<PieceStatusModel> getAll() {
        var entities = repository.findAll().stream().filter(p -> p.getDeleted() == 0);
        var response = entities.map(mapper::toPieceStatusModel).toList();
        return new GetListResponse<>(response);
    }
}
