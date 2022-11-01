package org.workshop.cc6.workshopserver.service.appointment;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.service.appointment.dto.AppointmentModel;
import org.workshop.cc6.workshopserver.service.appointment.dto.CreateAppointmentRequest;

public interface IAppointmentService {
    BaseResponse create(CreateAppointmentRequest dto);
    GetListResponse<AppointmentModel> getAll(Integer userId);
}
