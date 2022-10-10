package org.workshop.cc6.workshopserver.dto.workorderstatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderStatusModel {
    private Integer workOrderStatus;
    private String wokrOrderStatusDescription;
}
