package mantis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")

public class UserData {

    @Id
    private int id;
    @Column
    private String username;
    @Column
    private String email;

    public String getEmail() {
        return email;
    }


    public String getUsername() {
        return username;
    }


    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }
    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    public int getId() {
        return id;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
