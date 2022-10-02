package org.workshop.cc6.workshopserver.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "workshoplocation")
public class WorkshopLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @Column
    private String locationName;

    @Column
    private BigDecimal locationLatitude;

    @Column
    private BigDecimal locationLongitude;

    @Column
    private String locationAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkshopLocation that = (WorkshopLocation) o;

        if (!Objects.equals(locationId, that.locationId)) return false;
        if (!Objects.equals(locationName, that.locationName)) return false;
        if (!Objects.equals(locationLatitude, that.locationLatitude))
            return false;
        if (!Objects.equals(locationLongitude, that.locationLongitude))
            return false;
        return Objects.equals(locationAddress, that.locationAddress);
    }

    @Override
    public int hashCode() {
        int result = locationId != null ? locationId.hashCode() : 0;
        result = 31 * result + (locationName != null ? locationName.hashCode() : 0);
        result = 31 * result + (locationLatitude != null ? locationLatitude.hashCode() : 0);
        result = 31 * result + (locationLongitude != null ? locationLongitude.hashCode() : 0);
        result = 31 * result + (locationAddress != null ? locationAddress.hashCode() : 0);
        return result;
    }
}
