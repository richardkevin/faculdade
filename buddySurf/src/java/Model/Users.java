package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u where u.id = :id"),
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
    @Column
    private int max_guests;
    
    public Users(){
    }

    public Users(Long id, String username, String password, int age, String address, int max_guests){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
        this.max_guests = max_guests;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMax_guests(int max_guests) {
        this.max_guests = max_guests;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getMax_guests() {
        return max_guests;
    }
}
