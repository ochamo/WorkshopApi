package org.workshop.cc6.workshopserver.service.user;

import org.workshop.cc6.workshopserver.dto.user.LoginRequest;
import org.workshop.cc6.workshopserver.dto.user.LoginResponse;

public interface IUserService {
    LoginResponse login(LoginRequest user);

}
