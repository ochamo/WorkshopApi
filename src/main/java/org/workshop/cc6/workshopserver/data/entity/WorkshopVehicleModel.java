package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshopvehiclemodel")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopVehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modelId;

    @Column(length = 4)
    private String modelYear;

    @ManyToOne
    @JoinColumn(name = "modelLine")
    private WorkshopVehicleLine vehicleLine;

    @OneToMany(mappedBy = "workshopPieceModel")
    private Set<WorkshopVehiclePiece> workshopVehiclePieces;

    @OneToMany(mappedBy = "workshopClientVehicleModel")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopClientVehicle> clientVehicles;

    @Column
    private Byte deleted;

}
