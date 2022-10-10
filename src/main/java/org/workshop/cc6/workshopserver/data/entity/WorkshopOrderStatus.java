package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshoporderstatus")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopOrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workOrderStatusId;

    @Column
    private String wokrOrderStatusDescription;

    @OneToMany(mappedBy = "workshopOrderStatus")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopWorkOrder> workshopWorkOrders;

    @Column(insertable = false)
    private Byte deleted;
}
