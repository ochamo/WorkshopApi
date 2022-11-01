package org.workshop.cc6.workshopserver.service.advisorratedservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatedRatedServiceRequest {
    private Integer advisorId;
    private Integer workOrderId;
    private Integer userId;
    private String clientComment;
    private Byte clientScore;
}
