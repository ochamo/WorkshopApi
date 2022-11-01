package org.workshop.cc6.workshopserver.dto.workorder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

@Mapper
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkOrder {
    private Integer workOrderStatus;
}
