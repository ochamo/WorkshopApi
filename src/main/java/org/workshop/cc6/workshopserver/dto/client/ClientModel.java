package org.workshop.cc6.workshopserver.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    private Integer clientId;
    private String clientName;
    private String clientLastName;
    private String clientDpi;
    private String clientPhoneNumber;
    private Byte deleted;
}
