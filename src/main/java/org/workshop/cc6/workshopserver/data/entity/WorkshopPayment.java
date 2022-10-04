package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "workshoppayment")
@Setter
@Getter
@EqualsAndHashCode
public class WorkshopPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private WorkshopClient clientPayment;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private WorkshopWorkOrder workOrder;

    @Column
    private String cardNum;

    @CreationTimestamp
    private LocalDateTime paymentDate;

    @Column
    private BigDecimal total;

    @OneToMany(mappedBy = "billPayment")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopBill> workshopBillSet;
}
