package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopAdvisor;
import org.workshop.cc6.workshopserver.dto.advisor.AdvisorModel;
import org.workshop.cc6.workshopserver.dto.advisor.CreateAdvisorRequest;
import org.workshop.cc6.workshopserver.dto.advisor.UpdateAdvisorRequest;

@Mapper(
        componentModel = "spring"
)
public interface AdvisorMapper {
    WorkshopAdvisor toWorkshopAdvisor(CreateAdvisorRequest dto);
    WorkshopAdvisor updateToWorkshopAdvisor(UpdateAdvisorRequest dto);
    AdvisorModel toAdvisorModel(WorkshopAdvisor en);
}
