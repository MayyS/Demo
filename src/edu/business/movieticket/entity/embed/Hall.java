package edu.business.movieticket.entity.embed;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Hall {
    private int number;
    private Screen screen;
    private Auditorium auditorium;

    @Embedded
    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Embedded
    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
