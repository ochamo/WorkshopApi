package org.workshop.cc6.workshopserver.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "workshopclient")
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkshopClient that = (WorkshopClient) o;

        if (!Objects.equals(clientId, that.clientId)) return false;
        if (!Objects.equals(userId, that.userId)) return false;
        if (!Objects.equals(clientName, that.clientName)) return false;
        if (!Objects.equals(clientLastName, that.clientLastName))
            return false;
        if (!Objects.equals(clientDpi, that.clientDpi)) return false;
        return Objects.equals(clientPhoneNumber, that.clientPhoneNumber);
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientLastName != null ? clientLastName.hashCode() : 0);
        result = 31 * result + (clientDpi != null ? clientDpi.hashCode() : 0);
        result = 31 * result + (clientPhoneNumber != null ? clientPhoneNumber.hashCode() : 0);
        return result;
    }
}
