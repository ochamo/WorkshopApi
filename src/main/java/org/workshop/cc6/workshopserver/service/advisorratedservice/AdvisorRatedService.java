package org.workshop.cc6.workshopserver.service.advisorratedservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.entity.WorkshopAdvisorRatedService;
import org.workshop.cc6.workshopserver.data.repository.*;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.service.advisorratedservice.dto.CreatedRatedServiceRequest;

@Service
public class AdvisorRatedService implements IAdvisorRatedService {
    private final AdvisorRatedServiceRepository advisorRatedServiceRepository;
    private final AdvisorRepository advisorRepository;

    private final UserRepository userRepository;
    private final VehicleWorkOrderRepository workOrderRepository;

    private final ClientRepository clientRepository;

    @Autowired
    public AdvisorRatedService(AdvisorRatedServiceRepository advisorRatedServiceRepository, AdvisorRepository advisorRepository, UserRepository userRepository, VehicleWorkOrderRepository workOrderRepository, ClientRepository clientRepository) {
        this.advisorRatedServiceRepository = advisorRatedServiceRepository;
        this.advisorRepository = advisorRepository;
        this.userRepository = userRepository;
        this.workOrderRepository = workOrderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public BaseResponse createRatedService(CreatedRatedServiceRequest dto) {
        var advisor = advisorRepository.findById(dto.getAdvisorId());
        var workOrder = workOrderRepository.findById(dto.getWorkOrderId());
        var user = userRepository.findById(dto.getUserId());

        if (advisor.isEmpty()) {
            throw new IllegalArgumentException(String.format("advisor with id: %d not found", dto.getAdvisorId()));
        }

        if (workOrder.isEmpty()) {
            throw new IllegalArgumentException(String.format("work order with id: %d not found", dto.getWorkOrderId()));
        }

        if (user.isEmpty()) {
            throw new IllegalArgumentException(String.format("user with id: %d not found", dto.getUserId()));
        }

        var client = clientRepository.findByUserId(user.get().getUserId());

        if (client.isEmpty()) {
            throw new IllegalArgumentException("user is not of client type");
        }

        var entity = new WorkshopAdvisorRatedService();
        entity.setRatingClient(client.get());
        entity.setAdvisorRated(advisor.get());
        entity.setRatedWorkOrder(workOrder.get());
        entity.setClientScore(dto.getClientScore());
        entity.setClientComment(dto.getClientComment());

        advisorRatedServiceRepository.save(entity);

        return new BaseResponse("1");
    }
}
