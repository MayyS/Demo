package edu.business.movieticket.entity.embed;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Auditorium {
    private int totalSeat;
    private int selled;
    private boolean hasLeft;
    private int rol=10;
    private int col=10;

    @ElementCollection(targetClass = Seat.class)
    @CollectionTable(name = "seat_talbe",
        joinColumns = @JoinColumn(name = "id", nullable = false)
    )
    @Column(name = "seat")
    @OrderColumn(name = "list_order")
    private List<Seat>seats=new ArrayList<Seat>();
    private void  init(){
        totalSeat=rol*col;
        selled=0;
        hasLeft=true;
        for(int i=1; i<=rol; i++){
            for(int j=1; j<col; j++){
                Seat seat=new Seat(i,j);
                seats.add(seat);
            }
        }
    }

    public Auditorium(){
        init();
    }

    public Auditorium(int x, int y){
        this.rol=x;
        this.col=y;
        init();
    }


    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getSelled() {
        return selled;
    }

    public void setSelled(int selled) {
        this.selled+= selled;
    }

    public boolean isHasLeft() {
        return totalSeat>selled;
    }

    public void setHasLeft(boolean hasLeft) {
        this.hasLeft = hasLeft;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

}
