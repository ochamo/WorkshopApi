package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshopvehiclepiece")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopVehiclePiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pieceId;

    @ManyToOne
    @JoinColumn(name = "pieceType")
    private WorkshopPieceType workshopPieceType;

    @ManyToOne
    @JoinColumn(name = "pieceModel")
    private WorkshopVehicleModel workshopPieceModel;

    @OneToMany(mappedBy = "vehiclePiece")
    private Set<WorkshopPurchaseOrder> workshopVehiclePieces;

    @Column(insertable = false)
    private Byte deleted;
}
