package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author richard
 */
@Entity
@Table(name = "booking")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
})
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "booking_id", unique=true, nullable = false)
    private Long id;
    @Column(name = "guest_qty")
    private int guestQty;
    @Column
    private String dt_checkin;
    @Column
    private String dt_checkout;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users guest;

    public Booking() {
    }

    public Booking(Long id, int guestQty, String dt_checkin, String dt_checkout, Accommodation accommodation, Users guest) {
        this.id = id;
        this.guestQty = guestQty;
        this.dt_checkin = dt_checkin;
        this.dt_checkout = dt_checkout;
        this.accommodation = accommodation;
        this.guest = guest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGuestQty() {
        return guestQty;
    }

    public void setGuestQty(int guestQty) {
        this.guestQty = guestQty;
    }

    public String getDt_checkin() {
        return dt_checkin;
    }

    public void setDt_checkin(String dt_checkin) {
        this.dt_checkin = dt_checkin;
    }

    public String getDt_checkout() {
        return dt_checkout;
    }

    public void setDt_checkout(String dt_checkout) {
        this.dt_checkout = dt_checkout;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Users getGuest() {
        return guest;
    }

    public void setGuest(Users guest) {
        this.guest = guest;
    }

}
