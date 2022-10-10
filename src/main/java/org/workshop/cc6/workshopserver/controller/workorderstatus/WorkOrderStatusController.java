package org.workshop.cc6.workshopserver.controller.workorderstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.workorderstatus.CreateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.UpdateWorkOrderStatusRequest;
import org.workshop.cc6.workshopserver.dto.workorderstatus.WorkOrderStatusModel;
import org.workshop.cc6.workshopserver.service.workorderstatus.WorkOrderStatusService;

@RestController
@RequestMapping("/api/workorderstatus")
public class WorkOrderStatusController {
    private WorkOrderStatusService service;

    @Autowired
    public WorkOrderStatusController(WorkOrderStatusService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('advisor')")
    public ResponseEntity<?> create(CreateWorkOrderStatusRequest dto) {
        var response = service.create(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('advisor')")
    public ResponseEntity<?> update(UpdateWorkOrderStatusRequest dto) {
        var response = service.update(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('advisor')")
    public ResponseEntity<GetListResponse<WorkOrderStatusModel>> getAll() {
        var response = service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
