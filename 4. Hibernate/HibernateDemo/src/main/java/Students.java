import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="students")
public class Students {
    @Id
    private int id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "stud", fetch = FetchType.EAGER)
    private List<Laptop> laps=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(List<Laptop> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", laps=" + laps +
                '}';
    }
}
