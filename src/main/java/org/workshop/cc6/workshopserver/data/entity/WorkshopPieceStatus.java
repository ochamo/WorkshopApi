package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workshoppiecestatus")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopPieceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pieceStatusId;

    @Column
    private String pieceStatusDescription;

    @OneToMany(mappedBy = "workshopPieceStatus")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopWorkOrderDetail> workshopPieceStatuses;
}
