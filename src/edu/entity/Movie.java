package edu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Movie {

    private Integer id;

    //电影的名称
    private String name;
    //上映时间
    private Date releaseDate;
    //导演
    private String director;
    //演员
//    private Set<Celeberity> celebrity=new HashSet<Celeberity>();
    private String celebrity;

    public String getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(String celebrity) {
        this.celebrity = celebrity;
    }

    //类型
    private String genre;
    //国家
    private String country;
    //分数
    private double rate;
    //时长
    private int runtime;

    private String origin;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

/*
    public Set<Celeberity> getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Set<Celeberity> celebrity) {
        this.celebrity = celebrity;
    }
*/

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    private boolean mark;

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                ", celebrity='" + celebrity + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", rate=" + rate +
                ", runtime=" + runtime +
                ", origin='" + origin + '\'' +
                ", mark=" + mark +
                '}';
    }
}
