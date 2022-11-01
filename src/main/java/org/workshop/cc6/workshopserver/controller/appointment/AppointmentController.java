package org.workshop.cc6.workshopserver.controller.appointment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.service.appointment.AppointmentService;
import org.workshop.cc6.workshopserver.service.appointment.dto.AppointmentModel;
import org.workshop.cc6.workshopserver.service.appointment.dto.CreateAppointmentRequest;

@RestController
@RequestMapping("/api/cita")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetListResponse<AppointmentModel>> getAll(@PathVariable Integer userId) {
        var response = appointmentService.getAll(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateAppointmentRequest dto) {
        var response = appointmentService.create(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
