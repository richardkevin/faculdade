package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Rating.findByStars", query = "SELECT r FROM Rating r where r.stars = :stars"),
    @NamedQuery(name = "Rating.findByReceiver", query = "SELECT r FROM Rating r where r.receiver.id = :receiver_id"),
    @NamedQuery(name = "Rating.getReceiverAverage", query = "SELECT avg(r.stars + 0.0) FROM Rating r where r.receiver.id = :receiver_id"),
})
public class Rating implements Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "rate_id", unique=true, nullable = false)
    private Long id;
    @Column
    private int type;
    @Column
    private String description;
    @Column
    private int stars;
    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private Users sender;
    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    private Users receiver;

    public Rating(Long id, int type, String description, int stars, Users sender, Users receiver) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.stars = stars;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }
}
