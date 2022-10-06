package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "workshopworkorder")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopWorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workOrderId;

    @ManyToOne
    @JoinColumn(name = "workOrderStatus")
    private WorkshopOrderStatus workshopOrderStatus;

    @ManyToOne
    @JoinColumn(name = "clientVehicle")
    private WorkshopClientVehicle clientVehicle;

    @ManyToOne
    @JoinColumn(name = "advisorId")
    private WorkshopAdvisor advisorId;

    @Column
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime completionDate;

    @OneToMany(mappedBy = "workshopPieceStatus")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopWorkOrderDetail> workshopWorkOrderDetails;

    @OneToMany(mappedBy = "workshopWorkOrderId")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopWorkOrderGallery> workshopWorkOrderGalleries;

    @OneToMany(mappedBy = "workOrder")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopPayment> workshopPayments;

    @OneToMany(mappedBy = "ratedWorkOrder")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopAdvisorRatedService> workshopAdvisorRatedServices;

    @OneToMany(mappedBy = "purchaseOrderCode")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopPurchaseOrder> workshopPurchaseOrders;

    @Column
    private Byte deleted;
}
