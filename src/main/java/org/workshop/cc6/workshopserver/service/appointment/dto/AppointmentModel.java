package org.workshop.cc6.workshopserver.service.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.workshop.cc6.workshopserver.dto.advisor.AdvisorModel;
import org.workshop.cc6.workshopserver.dto.location.response.LocationModel;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentModel {
    private Integer appointmentId;
    private AdvisorModel advisorModel;
    private LocationModel locationModel;
    private LocalDateTime appointmentDate;
    private LocalDateTime appointmentTime;
}
