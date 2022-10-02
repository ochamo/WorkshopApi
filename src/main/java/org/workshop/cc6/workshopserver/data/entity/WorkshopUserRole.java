package org.workshop.cc6.workshopserver.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "WorkshopUserRole")
@Getter
@Setter
public class WorkshopUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte userRoleId;

    @Column
    private String userRoleDescription;


}
