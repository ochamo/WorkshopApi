package org.workshop.cc6.workshopserver.controller.advisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.advisor.AdvisorModel;
import org.workshop.cc6.workshopserver.dto.advisor.CreateAdvisorRequest;
import org.workshop.cc6.workshopserver.dto.advisor.UpdateAdvisorRequest;
import org.workshop.cc6.workshopserver.service.advisor.AdvisorService;

@RestController
@RequestMapping("/api/advisor")
public class AdvisorController {

    private AdvisorService advisorService;

    @Autowired
    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('advisor')")
    public ResponseEntity<?> create(@RequestBody CreateAdvisorRequest dto) {
        var response = advisorService.create(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('advisor')")
    public ResponseEntity<?> update(@RequestBody UpdateAdvisorRequest dto) {
        var response = advisorService.update(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('advisor')")
    public ResponseEntity<GetListResponse<AdvisorModel>> getAll() {
        var response = advisorService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
