package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workshopworkorderdetail")
@Setter
@Getter
@EqualsAndHashCode
public class WorkshopWorkOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workOrderDetailId;

    @ManyToOne
    @JoinColumn(name = "workOrderId")
    private WorkshopWorkOrder workOrderId;

    @ManyToOne
    @JoinColumn(name = "pieceTypeVehicle")
    private WorkshopPieceType workshopPieceTypeVehicle;

    @ManyToOne
    @JoinColumn(name = "pieceStatus")
    private WorkshopPieceStatus workshopPieceStatus;

    @Column
    private Byte deleted;
}
