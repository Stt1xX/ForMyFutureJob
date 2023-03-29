package Stt1xX;

import com.sun.istack.NotNull;

public class Coordinates {
    private double x;
    private Float y; //Поле не может быть null

    public Coordinates(double x, Float y){

    }

    @NotNull
    private void validX(double x){
        this.x = x;
    }
    @NotNull
    private void validY(Float y){
        this.y = y;
    }
}

