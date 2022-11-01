package org.workshop.cc6.workshopserver.dto.piece;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.workshop.cc6.workshopserver.dto.vehiclemodel.VehicleModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiclePieceModel {
    private Integer pieceId;
    private PieceTypeModel pieceTypeModel;
    private VehicleModel pieceVehicleModel;
}
