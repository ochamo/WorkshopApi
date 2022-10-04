package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workshopadvisorratedservice")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopAdvisorRatedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer advisorRateId;

    @ManyToOne
    @JoinColumn(name = "advisorId")
    private WorkshopAdvisor advisorRated;

    @ManyToOne
    @JoinColumn(name = "workOrderId")
    private WorkshopWorkOrder ratedWorkOrder;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private WorkshopClient ratingClient;

    @Column
    private Byte clientScore;

    @Column
    private String clientComment;
}
