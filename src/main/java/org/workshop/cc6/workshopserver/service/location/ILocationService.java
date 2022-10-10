package org.workshop.cc6.workshopserver.service.location;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.location.request.UpdateLocationRequest;
import org.workshop.cc6.workshopserver.dto.location.response.LocationModel;
import org.workshop.cc6.workshopserver.dto.user.CreateLocationRequest;

public interface ILocationService {
    BaseResponse createLocation(CreateLocationRequest req);
    BaseResponse updateLocation(UpdateLocationRequest req);

    GetListResponse<LocationModel> getLocations();

}
