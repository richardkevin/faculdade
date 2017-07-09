package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author richard
 */
@Entity
@Table(name = "accommodation")
@NamedQueries({
    @NamedQuery(name = "Accommodation.findAll", query = "SELECT a FROM Accommodation a"),
    @NamedQuery(name = "Accommodation.findById", query = "SELECT a FROM Accommodation a where a.id = :accommodation_id")
})
public class Accommodation implements Serializable {
    @Id
    @Column(name = "accommodation_id", unique=true, nullable = false)
    private Long id;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private String dt_start;
    @Column
    private String dt_end;
    @Column(name = "guest_price")
    private int guestPrice;
    @Column(name = "max_guests")
    private int maxGuests;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Users owner;
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="accommodation")
    private List<Booking> bookings;

    public Accommodation() {
    }

    public Accommodation(Long id, String country, String city, String dt_start, String dt_end, int guestPrice, int maxGuests, Users owner) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.dt_start = dt_start;
        this.dt_end = dt_end;
        this.guestPrice = guestPrice;
        this.maxGuests = maxGuests;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDt_start() {
        return dt_start;
    }

    public void setDt_start(String dt_start) {
        this.dt_start = dt_start;
    }

    public String getDt_end() {
        return dt_end;
    }

    public void setDt_end(String dt_end) {
        this.dt_end = dt_end;
    }

    public int getGuestPrice() {
        return guestPrice;
    }

    public void setGuestPrice(int guestPrice) {
        this.guestPrice = guestPrice;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }
}
