package org.workshop.cc6.workshopserver.controller.vehiclemodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.CreateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.UpdateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.VehicleModel;
import org.workshop.cc6.workshopserver.service.vehiclemodel.VehicleModelService;

@RestController
@RequestMapping("/api/vehicleModel")
public class VehicleModelController {
    private final VehicleModelService vehicleModelService;
    Logger logger = LoggerFactory.getLogger(VehicleModelController.class);


    public VehicleModelController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping
    public ResponseEntity<GetListResponse<VehicleModel>> getAll() {
        return new ResponseEntity<>(vehicleModelService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateVehicleModelRequest req) {
        try {
            var response = vehicleModelService.create(req);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(new BaseResponse("0", String.format("Error: %s", ex.getMessage())), HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody UpdateVehicleModelRequest req) {
        try {
            var response = vehicleModelService.update(req);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(new BaseResponse("0", String.format("Error: %s", ex.getMessage())), HttpStatus.OK);
        }
    }
}
