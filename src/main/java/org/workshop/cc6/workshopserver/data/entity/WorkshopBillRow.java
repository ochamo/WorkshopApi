package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "workshopbillrow")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopBillRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billRowId;

    @ManyToOne
    @JoinColumn(name = "billId")
    private WorkshopBill bill;

    @ManyToOne
    @JoinColumn(name = "pieceIdCode")
    private WorkshopVehiclePiece workshopVehiclePiece;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal unitPrice;

    @Column
    private Byte deleted;
}
