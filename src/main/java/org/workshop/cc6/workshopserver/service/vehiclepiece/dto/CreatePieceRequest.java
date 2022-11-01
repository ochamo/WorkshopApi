package org.workshop.cc6.workshopserver.service.vehiclepiece.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePieceRequest {
    private Integer pieceModel;
    private Integer pieceType;
}
