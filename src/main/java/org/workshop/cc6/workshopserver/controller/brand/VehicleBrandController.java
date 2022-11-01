package org.workshop.cc6.workshopserver.controller.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.brand.request.BrandModel;
import org.workshop.cc6.workshopserver.dto.brand.request.CreateBrandRequest;
import org.workshop.cc6.workshopserver.dto.brand.request.UpdateBrandRequest;
import org.workshop.cc6.workshopserver.service.vehiclebrand.IVehicleBrandService;

@RestController
@RequestMapping("/api/brand")
public class VehicleBrandController {
    private IVehicleBrandService brandService;

    @Autowired
    public VehicleBrandController(IVehicleBrandService brandService) {
        this.brandService = brandService;
    }

    @PreAuthorize("hasAuthority('advisor')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBrandRequest req) {
        var response = brandService.createVehicleBrand(req);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('advisor')")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UpdateBrandRequest req) {
        var response = brandService.updateVehicleBrand(req);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('advisor')")
    @GetMapping
    public ResponseEntity<GetListResponse<BrandModel>> getAll() {
        var response = brandService.getBrands();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
