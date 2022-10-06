package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshopvehicleline")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopVehicleLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lineId;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private WorkshopVehicleBrand workshopVehicleBrand;

    @Column
    private String lineName;

    @OneToMany(mappedBy = "vehicleLine")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopVehicleModel> workshopVehicleModels;

    @Column
    private Byte deleted;

}
