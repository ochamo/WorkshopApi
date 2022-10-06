package org.workshop.cc6.workshopserver.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="workshopuser")
@Getter
@Setter
@EqualsAndHashCode
public class WorkshopUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String userPass;
    @Column
    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "userRoleId")
    private WorkshopUserRole userRoleId;

    @Column
    private Byte deleted;

}
