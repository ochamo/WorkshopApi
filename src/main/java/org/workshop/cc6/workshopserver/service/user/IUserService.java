package org.workshop.cc6.workshopserver.service.user;

import org.workshop.cc6.workshopserver.dto.user.request.CreateUserClientRequest;
import org.workshop.cc6.workshopserver.dto.user.response.CreateUserClientResponse;

public interface IUserService {
    CreateUserClientResponse registerClient(CreateUserClientRequest user);

}
