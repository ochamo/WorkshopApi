package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "workshoppurchaseorder")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopPurchaseOrder {
    @Id
    @GeneratedValue
    private Integer workPurchaseOrderId;

    @ManyToOne
    @JoinColumn(name = "workOrderId")
    private WorkshopWorkOrder purchaseOrderCode;

    @ManyToOne
    @JoinColumn(name = "pieceVehicleId")
    private WorkshopVehiclePiece vehiclePiece;

    @Column
    private String distributorPieceId;

    @Column
    private BigDecimal precioU;

    @Column
    private Integer quantity;

    @Column
    private Byte deleted;
}
