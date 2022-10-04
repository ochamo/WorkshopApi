package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "workshopappointment")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private WorkshopClient appointmentClient;

    @ManyToOne
    @JoinColumn(name = "advisorId")
    private WorkshopAdvisor appointmentAdvisor;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private WorkshopLocation appointmentLocation;

    @Column
    private LocalDateTime appointmentDate;

    @Column
    private LocalDateTime appointmentTime;
}
