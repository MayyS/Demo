package edu.business.movieticket.entity;

import edu.business.movieticket.entity.embed.Seat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private Integer customer_id;
    private Integer cinema_id;
    private int hallNumber;
    private String screen_name;
    private List<Seat>seats=new ArrayList<>();

    private Date createdTime;
    private double cost;


}
