package Manager.MovieСharact;

import com.sun.istack.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "coordinates")
@XmlType(propOrder = {"x", "y"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    private Coordinates(){

    }
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

