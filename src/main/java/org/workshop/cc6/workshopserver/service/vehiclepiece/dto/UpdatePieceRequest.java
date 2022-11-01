package org.workshop.cc6.workshopserver.service.vehiclepiece.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePieceRequest {
    private Integer pieceId;
    private Integer pieceModel;
    private Integer pieceType;
    private Byte deleted;
}
