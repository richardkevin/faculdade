package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author richard
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u where u.id = :userId"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u where u.name = :name"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u where u.username = :username")})
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique=true, nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int age;
    @Column
    private String address;
    @Column(name = "allow_guest")
    private boolean allowGuest;
    @OneToMany(mappedBy="sender")
    private List<Rating> senders;
    @OneToMany(mappedBy="receiver")
    private List<Rating> receivers;

    public Users(){
    }

    public Users(Long id, String name, String username, String password, int age, String address, boolean allowGuest) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
        this.allowGuest = allowGuest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAllowGuest() {
        return allowGuest;
    }

    public void setAllowGuest(boolean allowGuest) {
        this.allowGuest = allowGuest;
    }

    public List<Rating> getSenders() {
        return senders;
    }

    public void setSenders(List<Rating> senders) {
        this.senders = senders;
    }

    public List<Rating> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Rating> receivers) {
        this.receivers = receivers;
    }
}
