package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "workshopadvisor")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopAdvisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer advisorId;

    @Column
    private Integer advisorLocation;

    @Column
    private Integer userId;

    @Column
    private String advisorName;

    @Column
    private String advisorLastName;

    @Column
    private String advisorDpi;

    @Column
    private String advisorPhoneNumber;

    @Column
    private String advisorAddress;

    @Column(insertable = false)
    private Byte deleted;

    @Column
    @CreationTimestamp
    private LocalDateTime advisorHiringDate;

    @OneToMany(mappedBy = "advisorId")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopWorkOrder> workshopWorkOrdersSet;

    @OneToMany(mappedBy = "appointmentAdvisor")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopAppointment> workshopAppointments;

    @OneToMany(mappedBy = "advisorRated")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopAdvisorRatedService> workshopAdvisorRatedServices;
}
