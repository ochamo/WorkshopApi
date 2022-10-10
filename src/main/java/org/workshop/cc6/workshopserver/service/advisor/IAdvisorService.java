package org.workshop.cc6.workshopserver.service.advisor;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.advisor.AdvisorModel;
import org.workshop.cc6.workshopserver.dto.advisor.CreateAdvisorRequest;
import org.workshop.cc6.workshopserver.dto.advisor.UpdateAdvisorRequest;

public interface IAdvisorService {
    BaseResponse create(CreateAdvisorRequest dto);
    BaseResponse update(UpdateAdvisorRequest dto);

    GetListResponse<AdvisorModel> getAll();
}
