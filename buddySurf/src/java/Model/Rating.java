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
@Table(name = "rate")
@NamedQueries({
    @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r"),
    @NamedQuery(name = "Rating.findById", query = "SELECT r FROM Rating r where r.id = :id"),
    @NamedQuery(name = "Rating.findByType", query = "SELECT r FROM Rating r where r.type = :type"),
    @NamedQuery(name = "Rating.findByStars", query = "SELECT r FROM Rating r where r.stars = :stars")})
public class Rating implements Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "rate_id", unique=true, nullable = false)
    private int id;
    @Column
    private int type;
    @Column
    private String description;
    @Column
    private int stars;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users user;

    private final int RATED_BY_FRIEND = 0;
    private final int RATED_BY_GUEST = 1;
    private final int RATED_BY_HOST = 2;
    private final int RATED_BY_CALLER = 3;
    private final int RATED_BY_INVITED = 4;

    public Rating() {
    }

    public Rating(int id, int type, String description, int stars) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
