package org.workshop.cc6.workshopserver.dto.workorderstatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWorkOrderStatusRequest {
    private Integer workOrderStatusId;
    private String wokrOrderStatusDescription;
    private Byte deleted;
}
