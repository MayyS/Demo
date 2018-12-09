package edu.entity;

import edu.business.common.Orders;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String account;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private boolean gender;
    private String email;
    private String phonenum;

    @ManyToMany(targetEntity = Movie.class, fetch = FetchType.EAGER)
    @JoinTable(name = "u_k_m",joinColumns = @JoinColumn(name = "pid",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "mid",referencedColumnName = "id")
    )
    private Set<Movie>movies=new HashSet<>();


    @ManyToMany(targetEntity = Orders.class,fetch = FetchType.EAGER ,cascade =CascadeType.ALL)
    @JoinTable(name = "u_o",joinColumns = @JoinColumn(name = "pid",referencedColumnName ="id"),
    inverseJoinColumns = @JoinColumn(name = "oid",referencedColumnName = "id")
    )
    private Set<Orders>oderss=new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Orders> getOderss() {
        return oderss;
    }

    public void setOderss(Set<Orders> oderss) {
        this.oderss = oderss;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", movies=" + movies +
                ", oderss=" + oderss +
                '}';
    }
}
