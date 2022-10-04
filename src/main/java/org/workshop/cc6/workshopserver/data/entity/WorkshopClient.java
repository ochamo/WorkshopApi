package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshopclient")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;

    @Column
    private Integer userId;

    @Column
    private String clientName;

    @Column
    private String clientLastName;

    @Column(length = 20)
    private String clientDpi;

    @Column(length = 20)
    private String clientPhoneNumber;

    @OneToMany(mappedBy = "workshopClient")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopClientVehicle> workshopClientVehicles;

    @OneToMany(mappedBy = "clientPayment")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopPayment> workshopPayments;

    @OneToMany(mappedBy = "appointmentClient")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopAppointment> workshopAppointments;

    @OneToMany(mappedBy = "ratingClient")
    private Set<WorkshopAdvisorRatedService> workshopAdvisorRatedServices;
}
