package org.workshop.cc6.workshopserver.service.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentRequest {
    private Integer userId;
    private String appointmentDate;
    private String appointmentTime;
    private Integer locationId;
}
