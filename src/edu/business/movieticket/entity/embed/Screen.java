package edu.business.movieticket.entity.embed;


import javax.persistence.Embeddable;


@Embeddable
public class Screen{


    private double price;

    private String screen_name;

    private String director;

    private String celebrity;

    private String genre;

    private String country;

    private int runtime;

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(String celebrity) {
        this.celebrity = celebrity;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Screen(){}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
