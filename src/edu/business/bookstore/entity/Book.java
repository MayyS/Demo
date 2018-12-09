package edu.business.bookstore.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name ="book")
public class Book {
    @Id
    @GenericGenerator(name = "assigned",strategy = "assigned")
    @GeneratedValue(generator = "assigned")
    private String ISBN;
    private String title;
    private String author;
    private Date publisher_time;
    private String publisher_hour;
    private double price_n;
    private double price_r;
    private double price_s;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublisher_time() {
        return publisher_time;
    }

    public void setPublisher_time(Date publisher_time) {
        this.publisher_time = publisher_time;
    }

    public String getPublisher_hour() {
        return publisher_hour;
    }

    public void setPublisher_hour(String publisher_hour) {
        this.publisher_hour = publisher_hour;
    }

    public double getPrice_n() {
        return price_n;
    }

    public void setPrice_n(double price_n) {
        this.price_n = price_n;
    }

    public double getPrice_r() {
        return price_r;
    }

    public void setPrice_r(double price_r) {
        this.price_r = price_r;
    }

    public double getPrice_s() {
        return price_s;
    }

    public void setPrice_s(double price_s) {
        this.price_s = price_s;
    }
}
