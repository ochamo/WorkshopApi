package org.workshop.cc6.workshopserver.service.appointment;

import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.entity.WorkshopAppointment;
import org.workshop.cc6.workshopserver.data.repository.*;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.mapper.AdvisorMapper;
import org.workshop.cc6.workshopserver.dto.mapper.LocationMapper;
import org.workshop.cc6.workshopserver.service.appointment.dto.AppointmentModel;
import org.workshop.cc6.workshopserver.service.appointment.dto.CreateAppointmentRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

@Service
public class AppointmentService implements IAppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AdvisorRepository advisorRepository;
    private final ClientRepository clientRepository;
    private final LocationMapper locationMapper;
    private final UserRepository userRepository;
    private final AdvisorMapper advisorMapper;
    private final LocationRepository locationRepository;

    public AppointmentService(
            AppointmentRepository appointmentRepository,
            AdvisorRepository advisorRepository,
            ClientRepository clientRepository,
            LocationMapper locationMapper,
            UserRepository userRepository,
            AdvisorMapper advisorMapper,
            LocationRepository locationRepository) {
        this.appointmentRepository = appointmentRepository;
        this.advisorRepository = advisorRepository;
        this.locationMapper = locationMapper;
        this.advisorMapper = advisorMapper;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public BaseResponse create(CreateAppointmentRequest dto) {
        var entity = new WorkshopAppointment();
        var date = LocalDate.parse(dto.getAppointmentDate());
        var time = LocalTime.parse(dto.getAppointmentTime());
        var appointmentTime = LocalDateTime.of(date, time);
        var location = locationRepository.findById(dto.getLocationId());
        entity.setAppointmentDate(appointmentTime);
        entity.setAppointmentTime(appointmentTime);
        var advisors = advisorRepository.findAllByAdvisorLocation(dto.getLocationId());
        var random = new Random();
        var advisorSelected = random.nextInt(advisors.size());
        var advisor = advisors.get(advisorSelected);
        entity.setAppointmentAdvisor(advisor);
        var user = userRepository.findById(dto.getUserId());
        var client = clientRepository.findByUserId(user.get().getUserId());
        entity.setAppointmentClient(client.get());
        entity.setAppointmentLocation(location.get());
        appointmentRepository.save(entity);
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<AppointmentModel> getAll(Integer userId) {
        var items = appointmentRepository.findByClientId(userId)
                .stream().map(p -> {
                    var model = new AppointmentModel();
                    model.setAdvisorModel(advisorMapper.toAdvisorModel(p.getAppointmentAdvisor()));
                    model.setLocationModel(locationMapper.workshopLocationToGetLocationResponse(p.getAppointmentLocation()));
                    model.setAppointmentId(p.getAppointmentId());
                    model.setAppointmentDate(p.getAppointmentDate());
                    model.setAppointmentTime(p.getAppointmentTime());
                    return model;
                }).toList();
        return new GetListResponse<>(items);
    }
}
