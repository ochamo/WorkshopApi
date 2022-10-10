package org.workshop.cc6.workshopserver.service.vehicleline;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.vehicleline.CreateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.vehicleline.UpdateVehicleLineRequest;
import org.workshop.cc6.workshopserver.dto.vehicleline.VehicleLineModel;

public interface IVehicleLineService {
    BaseResponse create(CreateVehicleLineRequest req);
    BaseResponse update(UpdateVehicleLineRequest req);

    GetListResponse<VehicleLineModel> getAll();

}
