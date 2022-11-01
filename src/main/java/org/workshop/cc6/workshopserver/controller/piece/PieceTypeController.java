package org.workshop.cc6.workshopserver.controller.piece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.piece.PieceTypeModel;
import org.workshop.cc6.workshopserver.service.piecetype.PieceTypeService;

@RestController
@RequestMapping("/api/piecetype")
public class PieceTypeController {
    private final PieceTypeService pieceTypeService;

    @Autowired
    public PieceTypeController(PieceTypeService pieceTypeService) {
        this.pieceTypeService = pieceTypeService;
    }

    @GetMapping
    public ResponseEntity<GetListResponse<PieceTypeModel>> getAll() {
        var response = pieceTypeService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
