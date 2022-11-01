package org.workshop.cc6.workshopserver.dto.piece;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PieceTypeModel {
    private Integer pieceTypeId;
    private String pieceName;
}
