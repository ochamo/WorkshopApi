package org.workshop.cc6.workshopserver.service.piecetype;

import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.repository.PieceTypeRepository;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.piece.PieceTypeModel;

@Service
public class PieceTypeService implements IPieceTypeService {
    private final PieceTypeRepository repository;

    public PieceTypeService(PieceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetListResponse<PieceTypeModel> getAll() {
        var items = repository.findAll().stream().map(
                p -> {
                    var piece = new PieceTypeModel();
                    piece.setPieceTypeId(p.getPieceTypeId());
                    piece.setPieceName(p.getPieceName());
                    return piece;
                }
        ).toList();

        return new GetListResponse<>(items);
    }
}
