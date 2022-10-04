package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workshopvehiclebrand")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopVehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;

    @Column
    private String brandName;

    @OneToMany(mappedBy = "workshopVehicleBrand")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopVehicleLine> workshopVehicleLines;

}
