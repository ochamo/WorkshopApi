package org.workshop.cc6.workshopserver.service.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.entity.WorkshopLocation;
import org.workshop.cc6.workshopserver.data.repository.LocationRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.location.request.UpdateLocationRequest;
import org.workshop.cc6.workshopserver.dto.mapper.LocationMapper;
import org.workshop.cc6.workshopserver.dto.user.CreateLocationRequest;

@Service
public class LocationService implements ILocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper mapper;


    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper mapper) {
        this.locationRepository = locationRepository;
        this.mapper = mapper;
    }


    @Override
    public BaseResponse createLocation(CreateLocationRequest req) {
        var location = mapper.workshopLocationToCreateLocationRequest(req);
        locationRepository.save(location);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse updateLocation(UpdateLocationRequest req) {
        var location = mapper.workshopLocationToUpdateLocationRequest(req);
        locationRepository.save(location);
        return new BaseResponse("1");
    }
}
