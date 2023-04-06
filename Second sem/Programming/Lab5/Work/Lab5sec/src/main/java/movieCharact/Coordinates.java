package movieCharact;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coordinates {

    public Coordinates(){

    }
    public Coordinates(Double x, Float y){
        this.x = x;
        this.y = y;
    }
    @XmlElement(name = "coordinateX")
    private Double x; //Поле не может быть null
    @XmlElement(name = "coordinateY")
    private Float y; //Поле не может быть null

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }
}