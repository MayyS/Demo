package edu.business.movieticket.entity;


import edu.business.movieticket.entity.embed.Hall;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
public class Cinema {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private  int id;
    private String address;
    private Hall hall;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    @Embedded
    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
