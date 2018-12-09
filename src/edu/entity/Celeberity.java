package edu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Celeberity {


    private Integer id;
    //演员的姓名
    private String name;
    //性别
    private boolean gender;
    //生日
    private Date birthDate;
    //国家
    private String homePlace;
    //参加的电影
    /*private Set<Movie>movies=new HashSet<Movie>();

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
*/
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomePlace() {
        return homePlace;
    }

    public void setHomePlace(String homePlace) {
        this.homePlace = homePlace;
    }
}
