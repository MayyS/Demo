package edu.business.movieticket.entity.embed;

import javax.persistence.Embeddable;



@Embeddable
public class Seat {
    private int col;
    private int rol;
    private boolean isSelled;

    public Seat(){
        this.isSelled=false;
    }
    public Seat(int rol,int col){
        this.rol=rol;
        this.col=col;
        this.isSelled=false;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isSelled() {
        return isSelled;
    }

    public void setSelled(boolean selled) {
        isSelled = selled;
    }
}
