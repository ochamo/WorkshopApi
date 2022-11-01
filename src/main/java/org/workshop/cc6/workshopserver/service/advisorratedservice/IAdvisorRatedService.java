package org.workshop.cc6.workshopserver.service.advisorratedservice;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.service.advisorratedservice.dto.CreatedRatedServiceRequest;

public interface IAdvisorRatedService {
    BaseResponse createRatedService(CreatedRatedServiceRequest dto);
}
