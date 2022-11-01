package org.workshop.cc6.workshopserver.service.vehiclemodel;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.CreateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.UpdateVehicleModelRequest;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.VehicleModel;

public interface IVehicleModelService {

    BaseResponse create(CreateVehicleModelRequest req);

    BaseResponse update(UpdateVehicleModelRequest req);

    GetListResponse<VehicleModel> getAll();

}
