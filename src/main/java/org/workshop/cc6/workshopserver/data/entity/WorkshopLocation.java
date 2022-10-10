package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "workshoplocation")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @Column
    private String locationName;

    @Column
    private BigDecimal locationLatitude;

    @Column
    private BigDecimal locationLongitude;

    @Column
    private String locationAddress;

    @OneToMany(mappedBy = "appointmentLocation")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopAppointment> workshopAppointmentSet;

    @Column(insertable = false)
    private Byte deleted;
}
