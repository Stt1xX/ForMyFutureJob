package Stt1xX;

import com.sun.istack.NotNull;
import javax.management.InvalidAttributeValueException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Movie {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person operator; //Поле не может быть null
    private static long nextId = 1;
    public Movie(String name, Coordinates coordinates, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator) throws InvalidAttributeValueException {
        setId();
        validName(name);
        this.creationDate = LocalDate.ofEpochDay((int) (Math.random() * 10000));
        validCoordinates(coordinates);
        validOscars(oscarsCount);
        validRating(mpaaRating);
        validGenre(genre);
        validPerson(operator);
    }

    Set<Long> Id = new HashSet<>();
    @NotNull
    private void setId(){
        if (nextId == Long.MAX_VALUE){
            this.id = 1L;
            nextId = 1;
        }
        else{
            this.id = nextId;
            nextId += 1;
        }
        Id.add(this.id);
    }
    @NotNull
    private void validName(String name) throws InvalidAttributeValueException {
        if (name.equals("")) {
            throw new InvalidAttributeValueException("Имя фильма не может быть пустым");
        }
        else{
            this.name = name;
        }
    }
    @NotNull
    private void validPerson(Person person){
        this.operator = person;
    }

    @NotNull
    private void validRating(MpaaRating rating){
        this.mpaaRating = rating;
    }

    @NotNull
    private void validGenre(MovieGenre genre){
        this.genre = genre;
    }

    @NotNull
    private void validOscars(Long number) throws InvalidAttributeValueException{
        if (number > 0){
            this.oscarsCount = number;
        }
        else{
            throw new InvalidAttributeValueException("У этого шедевра оскаров явно больше чем " + number);
        }
    }

    @NotNull
    private void validCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }



}

