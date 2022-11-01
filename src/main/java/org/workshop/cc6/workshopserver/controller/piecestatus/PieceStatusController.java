package org.workshop.cc6.workshopserver.controller.piecestatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.piecestatus.CreatePieceStatusRequest;
import org.workshop.cc6.workshopserver.dto.piecestatus.UpdatePieceStatusRequest;
import org.workshop.cc6.workshopserver.service.piecestatus.PieceStatusService;

@RestController
@RequestMapping("/api/piecestatus")
public class PieceStatusController {
    private PieceStatusService service;

    @Autowired
    public PieceStatusController(PieceStatusService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreatePieceStatusRequest dto) {
        var response = service.create(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UpdatePieceStatusRequest dto) {
        var response = service.update(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        var response = service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
