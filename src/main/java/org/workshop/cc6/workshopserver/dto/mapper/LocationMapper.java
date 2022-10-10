package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopLocation;
import org.workshop.cc6.workshopserver.dto.location.request.UpdateLocationRequest;
import org.workshop.cc6.workshopserver.dto.location.response.LocationModel;
import org.workshop.cc6.workshopserver.dto.user.CreateLocationRequest;

@Mapper(
        componentModel = "spring"
)
public interface LocationMapper {
    WorkshopLocation workshopLocationToUpdateLocationRequest(UpdateLocationRequest dto);
    WorkshopLocation workshopLocationToCreateLocationRequest(CreateLocationRequest dto);

    LocationModel workshopLocationToGetLocationResponse(WorkshopLocation dto);
}
