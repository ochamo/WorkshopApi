package org.workshop.cc6.workshopserver.controller.clientvehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.clientvehicle.ClientVehicleModel;
import org.workshop.cc6.workshopserver.dto.clientvehicle.CreateClientVehicle;
import org.workshop.cc6.workshopserver.dto.clientvehicle.UpdateClientVehicle;
import org.workshop.cc6.workshopserver.service.clientvehicle.ClientVehicleService;

@RestController
@RequestMapping("/api/clientvehicle")
public class ClientVehicleController {
    private ClientVehicleService clientVehicleService;

    @Autowired
    public ClientVehicleController(ClientVehicleService clientVehicleService) {
        this.clientVehicleService = clientVehicleService;
    }

    @PostMapping
    public ResponseEntity<?> create(CreateClientVehicle req) {
        var response = clientVehicleService.create(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(UpdateClientVehicle req) {
        var response = clientVehicleService.update(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetListResponse<ClientVehicleModel>> getAll(@PathVariable int id) {
        var response = clientVehicleService.getAll(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
