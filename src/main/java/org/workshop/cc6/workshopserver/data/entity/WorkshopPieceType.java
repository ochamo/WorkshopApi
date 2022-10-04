package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workshoppiecetype")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopPieceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pieceTypeId;

    @Column
    private String pieceName;

    @OneToMany(mappedBy = "workshopPieceType")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopVehiclePiece> workshopVehiclePieces;

    @OneToMany
    @EqualsAndHashCode.Exclude
    private Set<WorkshopWorkOrderDetail> workshopWorkOrderDetails;
}
