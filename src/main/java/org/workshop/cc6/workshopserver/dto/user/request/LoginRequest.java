package org.workshop.cc6.workshopserver.dto.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String userEmail;
    private String userPassword;
}
