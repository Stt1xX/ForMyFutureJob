package Manager.MovieСharact;

import com.sun.istack.NotNull;

import javax.management.InvalidAttributeValueException;

public class Location {
    private Location(){

    }
    private float x;
    private float y;
    private long z;
    private String name; //Длина строки не должна быть больше 870, Поле не может быть null

    public Location(float x, float y, long z, String name) throws InvalidAttributeValueException {
        this.x = x;
        this.y = y;
        this.z = z;
        validName(name);
    }

    @NotNull
    private void validName(String name)throws InvalidAttributeValueException {
        if (name.length() > 870){
            throw new InvalidAttributeValueException("Строка слишком большая");
        }
        else{
            this.name = name;
        }
    }
}
