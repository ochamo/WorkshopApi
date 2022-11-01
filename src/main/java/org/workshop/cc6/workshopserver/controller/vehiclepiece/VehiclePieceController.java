package org.workshop.cc6.workshopserver.controller.vehiclepiece;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.piece.VehiclePieceModel;
import org.workshop.cc6.workshopserver.service.vehiclepiece.VehiclePieceService;
import org.workshop.cc6.workshopserver.service.vehiclepiece.dto.CreatePieceRequest;
import org.workshop.cc6.workshopserver.service.vehiclepiece.dto.UpdatePieceRequest;

@RestController
@RequestMapping("/api/vehiclepiece")
public class VehiclePieceController {
    private VehiclePieceService vehiclePieceService;

    public VehiclePieceController(VehiclePieceService vehiclePieceService) {
        this.vehiclePieceService = vehiclePieceService;
    }

    @GetMapping("/{pieceModel}")
    public ResponseEntity<GetListResponse<VehiclePieceModel>> getAll(@PathVariable Integer pieceModel) {
        var result = vehiclePieceService.getAll(pieceModel);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreatePieceRequest dto) {
        var result = vehiclePieceService.create(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody UpdatePieceRequest dto) {
        var result = vehiclePieceService.update(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
