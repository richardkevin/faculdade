package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author richard
 */
@Entity
@Table(name = "accommodation")
@NamedQueries({
    @NamedQuery(name = "Accommodation.findAll", query = "SELECT a FROM Accommodation a")})
public class Accommodation implements Serializable {
    @Id
    @Column(name = "accommodation_id", unique=true, nullable = false)
    private Long id;
    private String country;
    private String city;
    private List<Date> availableDates;
    private List<Date> unavailableDates;
}
