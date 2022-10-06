package org.workshop.cc6.workshopserver.controller.location;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.user.CreateLocationRequest;
import org.workshop.cc6.workshopserver.service.location.ILocationService;
import org.workshop.cc6.workshopserver.service.location.LocationService;

@RestController
@RequestMapping("/location/")
public class LocationController {
    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @PreAuthorize("hasRole('2') or hasRole('1')")
    @PostMapping
    public ResponseEntity<BaseResponse> createLocation(@RequestBody CreateLocationRequest req) {
        var response = locationService.createLocation(req);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
