package Manager.MovieСharact;

import com.sun.istack.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import javax.management.InvalidAttributeValueException;
@XmlRootElement(name = "operator")
@XmlType(propOrder = {"name", "height", "eyeColor", "nationality", "location"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    private Person(){

    }
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long height; //Поле может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле может быть null

    public Person(String name, Long height, Color eyeColor, Country nationality, Location location) throws InvalidAttributeValueException{
        validEyeColor(eyeColor);
        validHeight(height);
        validName(name);
        validLocation(location);
        validCountry(nationality);
    }

    @NotNull
    private void validEyeColor(Color eyeColor){
        this.eyeColor = eyeColor;
    }

    @NotNull
    private void validName(String name) throws InvalidAttributeValueException {
        if (name.equals("")) {
            throw new InvalidAttributeValueException("Имя автора не может быть пустым");
        }
        else{
            this.name = name;
        }
    }
    @NotNull
    private void validHeight(Long number) throws InvalidAttributeValueException{
        if (number > 0){
            this.height = number;
        }
        else{
            throw new InvalidAttributeValueException("У этого пупса рост явно больше чем " + number);
        }
    }

    @NotNull
    private void validCountry(Country country){
        this.nationality = country;
    }
    @NotNull
    private void validLocation(Location location){
        this.location = location;
    }
}
