package org.workshop.cc6.workshopserver.service.user;

import org.workshop.cc6.workshopserver.dto.user.LoginRequest;

public class IUserService {

    LoginResponse login(LoginRequest user);

}
