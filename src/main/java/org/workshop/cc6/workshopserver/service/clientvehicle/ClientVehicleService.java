package org.workshop.cc6.workshopserver.service.clientvehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.repository.ClientRepository;
import org.workshop.cc6.workshopserver.data.repository.ClientVehicleRepository;
import org.workshop.cc6.workshopserver.data.repository.VehicleModelRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.clientvehicle.ClientVehicleModel;
import org.workshop.cc6.workshopserver.dto.clientvehicle.CreateClientVehicle;
import org.workshop.cc6.workshopserver.dto.clientvehicle.UpdateClientVehicle;
import org.workshop.cc6.workshopserver.dto.mapper.ClientVehicleMapper;

@Service
public class ClientVehicleService implements IClientVehicleService {
    private ClientVehicleRepository repository;
    private ClientVehicleMapper mapper;
    private VehicleModelRepository modelRepository;
    private ClientRepository clientRepository;

    @Autowired
    public ClientVehicleService(ClientVehicleRepository repository, ClientVehicleMapper mapper, VehicleModelRepository modelRepository, ClientRepository clientRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.modelRepository = modelRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public BaseResponse create(CreateClientVehicle dto) {
        var client = clientRepository.findById(dto.getClientId()).get();
        var model = modelRepository.findById(dto.getVehicleModelId()).get();
        var clientVehicle = mapper.createToEntity(dto);
        clientVehicle.setWorkshopClient(client);
        clientVehicle.setWorkshopClientVehicleModel(model);
        repository.save(clientVehicle);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse update(UpdateClientVehicle dto) {
        var model = modelRepository.findById(dto.getVehicleModelId()).get();
        repository.updateSome(model, dto.getVehiclePlate(), (byte) dto.getDeleted());
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<ClientVehicleModel> getAll(int id) {
        var entities = repository.getByClientId(id);
        var items = entities.stream().map(mapper::toModel).toList();
        return new GetListResponse<>(items);
    }
}
