package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workshopworkordergallery")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopWorkOrderGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workOrderImageId;

    @ManyToOne
    @JoinColumn(name = "workOrderId")
    private WorkshopWorkOrder workshopWorkOrderId;

    @Column
    private String imagePath;

    @Column
    private Byte deleted;
}
