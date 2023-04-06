package movieCharact;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Scanner;
@XmlRootElement
public class Person {
    public Person(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private Long height; //Поле может быть null, Значение поля должно быть больше 0
    @XmlElement
    private Color eyeColor; //Поле не может быть null
    @XmlElement
    private Country nationality; //Поле не может быть null
    @XmlElement
    private Location location; //Поле может быть null

    public void createHeight(Scanner scanner){
        while (true){
            if (scanner.hasNextLong()){
                break;
            }
            else{
                System.out.println("Это не число");
                scanner.next();
            }
        }
        while(true){
            Long height = scanner.nextLong();
            if(height.intValue() <= 0){
                System.out.println("Ошибка, поле \"рост\" не " +
                        "может быть пусым и должно быть больше нуля");
            }
            else{
                this.height = height;
                break;
            }
        }
    }

    public void createName(Scanner scanner){
        while(true){
            String name = scanner.next();
            if(name.equals("")){
                System.out.println("Ошибка, поле \"имя автора\" не может быть пустым");
            }
            else{
                this.name = name;
                break;
            }
        }
    }
    public enum Color {
        GREEN,
        RED,
        BLACK,
        BLUE,
        BROWN;
    }

    public void createColor(Scanner scanner){
        while (true) {
            try {
                String eyeColor = scanner.next();
                if (eyeColor.equals("")) {
                    System.out.println("Ошибка, поле \"цвет глаз автора\" не может быть пустым");
                } else {
                    this.eyeColor = Color.valueOf(eyeColor);
                    break;
                }
            }catch(IllegalArgumentException e){
                System.out.println("Такого цвета глаз не существует в природе");
            }
        }
    }

    public enum Country {
        FRANCE,
        VATICAN,
        THAILAND,
        NORTH_KOREA,
        JAPAN;
    }

    public void createCountry(Scanner scanner){
        while (true) {
            try {
                String country = scanner.next();
                if (country == null) {
                    System.out.println("Ошибка, поле \"название страны\" не может быть пустым");
                } else {
                    this.nationality = Country.valueOf(country);
                    break;
                }
            }catch(IllegalArgumentException e){
                System.out.println("Такой страны не существует в природе");
            }
        }
    }
    public void createLocation(Scanner scanner){
        Float x, y;
        Long z;
        while (true){
            if (scanner.hasNextFloat()){
                x = scanner.nextFloat();
                break;
            }
            else{
                System.out.println("Это не число");
                scanner.next();
            }
        }
        while (true){
            if (scanner.hasNextFloat()){
                y = scanner.nextFloat();
                break;
            }
            else{
                System.out.println("Это не число");
                scanner.next();
            }
        }
        while (true){
            if (scanner.hasNextLong()){
                z = scanner.nextLong();
                break;
            }
            else{
                System.out.println("Это не число");
                scanner.next();
            }
        }
        while(true){
            String name = scanner.next();
            if (name == null || name.length() > 870){
                System.out.println("Ошибка, поле \"название локации автора\" не может " +
                        "быть пустым, и не может быть больше 870 символов, введите всю локацию заново");
            }
            else{
                this.location = new Location(x, y, z, name);
                break;
            }
        }
    }
}
