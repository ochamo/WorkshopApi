package org.workshop.cc6.workshopserver.controller.vehicleline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.vehicleline.CreateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.vehicleline.UpdateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.vehicleline.VehicleLineModel;
import org.workshop.cc6.workshopserver.service.vehicleline.VehicleLineService;

@RestController
@RequestMapping("/api/vehicleline")
public class VehicleLineController {
    private VehicleLineService vehicleLineService;

    @Autowired
    public VehicleLineController(VehicleLineService vehicleLineService) {
        this.vehicleLineService = vehicleLineService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateVehicleLineRequest req) {
        var response = vehicleLineService.create(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UpdateVehicleLineRequest req) {
        var response = vehicleLineService.update(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetListResponse<VehicleLineModel>> getAll() {
        var response = vehicleLineService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
