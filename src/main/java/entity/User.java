package entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by Julia on 14.05.2016.
 */

@Entity
@Table(name = "users")
@NamedQuery(name = "User.getAll", query = "SELECT u from User u")
public class User{
    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    @Column(name = "email")
    private String email;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public User(){}

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getLogin(){
        return this.login;
    }

    public  void  setLogin(String login){
        this.login = login;
    }

    public  String getPassword(){
        return this.password;
    }

    public  void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User{ id= %d, login= %s, mail= %s, password= %s}",
                this.id, this.login, this.email, this.password);
    }
}
