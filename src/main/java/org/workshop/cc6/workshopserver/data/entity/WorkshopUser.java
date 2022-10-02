package org.workshop.cc6.workshopserver.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="WorkshopUser")
@Getter
@Setter
public class WorkshopUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String userPass;
    @Column
    private String userEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userRoleId")
    private WorkshopUserRole userRoleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkshopUser that = (WorkshopUser) o;

        if (!Objects.equals(userId, that.userId)) return false;
        if (!Objects.equals(userPass, that.userPass)) return false;
        return Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        return result;
    }
}
