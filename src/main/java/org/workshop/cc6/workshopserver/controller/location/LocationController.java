package org.workshop.cc6.workshopserver.controller.location;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.location.request.UpdateLocationRequest;
import org.workshop.cc6.workshopserver.dto.location.response.LocationModel;
import org.workshop.cc6.workshopserver.dto.user.CreateLocationRequest;
import org.workshop.cc6.workshopserver.service.location.ILocationService;

@RestController
@RequestMapping("/api/location/")
public class LocationController {
    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @PreAuthorize("hasAuthority('advisor')")
    @PostMapping
    public ResponseEntity<BaseResponse> createLocation(@RequestBody CreateLocationRequest req) {
        var response = locationService.createLocation(req);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('advisor')")
    @GetMapping
    public ResponseEntity<GetListResponse<LocationModel>> getLocations() {
        var response = locationService.getLocations();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PreAuthorize("hasAuthority('advisor')")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestParam Integer id, @RequestBody UpdateLocationRequest req) {
        var response = locationService.updateLocation(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
