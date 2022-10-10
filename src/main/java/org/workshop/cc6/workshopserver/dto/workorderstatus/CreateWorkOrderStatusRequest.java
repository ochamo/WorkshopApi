package org.workshop.cc6.workshopserver.dto.workorderstatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkOrderStatusRequest {
    private String wokrOrderStatusDescription;
}
