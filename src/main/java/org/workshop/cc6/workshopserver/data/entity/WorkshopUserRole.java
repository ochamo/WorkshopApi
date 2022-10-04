package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "WorkshopUserRole")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte userRoleId;

    @Column
    private String userRoleDescription;

    @OneToMany(mappedBy = "userRoleId")
    @EqualsAndHashCode.Exclude
    private Set<WorkshopUser> users;

}
