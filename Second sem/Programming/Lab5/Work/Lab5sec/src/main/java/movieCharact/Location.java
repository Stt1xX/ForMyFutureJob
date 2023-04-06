package movieCharact;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
    public Location(){

    }
    @XmlElement(name = "coordinateX")
    private float x;
    @XmlElement(name = "coordinateY")
    private float y;
    @XmlElement(name = "coordinateZ")
    private long z;
    @XmlElement(name = "nameOfLocation")
    private String name; // Длина строки не должна быть больше 870, Поле не может быть null

    public Location(float x, float y, long z, String name){
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(long z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }
}
