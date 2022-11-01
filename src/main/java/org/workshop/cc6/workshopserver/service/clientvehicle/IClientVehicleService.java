package org.workshop.cc6.workshopserver.service.clientvehicle;

import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.clientvehicle.ClientVehicleModel;
import org.workshop.cc6.workshopserver.dto.clientvehicle.CreateClientVehicle;
import org.workshop.cc6.workshopserver.dto.clientvehicle.UpdateClientVehicle;

public interface IClientVehicleService {
    BaseResponse create(CreateClientVehicle dto);
    BaseResponse update(UpdateClientVehicle dto);
    GetListResponse<ClientVehicleModel> getAll(int id);
}
