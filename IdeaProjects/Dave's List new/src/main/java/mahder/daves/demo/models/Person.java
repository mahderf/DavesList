package mahder.daves.demo.models;

import mahder.daves.demo.repository.RoomsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ArrayList<Rooms>roomsinstance=new ArrayList<Rooms>();
//    private ArrayList<Education>educations=new ArrayList<Education>();
    private String firstname;

    private String lastname;

    private String  phonenumber;

    private String  email;

    public ArrayList<Rooms> getRoomsinstance() {
        return roomsinstance;
    }

    public void setRoomsinstance(ArrayList<Rooms> roomsinstance) {
        this.roomsinstance = roomsinstance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
