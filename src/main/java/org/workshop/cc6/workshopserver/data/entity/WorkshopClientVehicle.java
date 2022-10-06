package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshopclientvehicle")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopClientVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer VehicleId;

    @Column
    private String vehiclePlate;

    @ManyToOne
    @JoinColumn(name = "vehicleModelId")
    private WorkshopVehicleModel workshopClientVehicleModel;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private WorkshopClient workshopClient;

    @OneToMany(mappedBy = "clientVehicle")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopWorkOrder> workshopWorkOrders;

    @Column
    private Byte deleted;
}
