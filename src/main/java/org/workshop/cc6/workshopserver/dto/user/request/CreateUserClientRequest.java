package org.workshop.cc6.workshopserver.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserClientRequest {
    private String userEmail;
    private String userPass;
    private String clientName;
    private String clientLastName;
    private String clientDpi;
    private String clientPhoneNumber;
}
