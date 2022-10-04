package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshopbill")
@Setter
@Getter
@EqualsAndHashCode
public class WorkshopBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workshopBillId;

    @ManyToOne
    @JoinColumn(name = "paymentId")
    private WorkshopPayment billPayment;

    @Column
    private String billName;

    @Column
    private String billNit;

    @OneToMany(mappedBy = "bill")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopBillRow> workshopBillRowSet;
}
