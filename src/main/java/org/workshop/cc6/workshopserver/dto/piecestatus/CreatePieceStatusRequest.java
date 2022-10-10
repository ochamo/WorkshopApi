package org.workshop.cc6.workshopserver.dto.piecestatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePieceStatusRequest {
    private String pieceStatusDescription;
}