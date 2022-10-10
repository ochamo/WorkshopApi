package org.workshop.cc6.workshopserver.dto.mapper;

import org.mapstruct.Mapper;
import org.workshop.cc6.workshopserver.data.entity.WorkshopClient;
import org.workshop.cc6.workshopserver.dto.client.ClientModel;

@Mapper(
        componentModel = "spring"
)
public interface ClientMapper {
    ClientModel toClientModel(WorkshopClient en);
}
