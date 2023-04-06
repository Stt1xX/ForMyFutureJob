package movieCharact;

import jakarta.xml.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
@XmlRootElement(name = "movie")
public class Movie {

    public Movie(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setOscarsCount(Long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0,
    // Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null

    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private Long oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null

    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person operator; //Поле не может быть null

    @XmlTransient
    Set<Long> Id = new HashSet<>();
    private static long nextId = 1;
    public void createId(){
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

    public void createDate(){
        this.creationDate =
                LocalDate.ofEpochDay((int) (Math.random() * 10000)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public void createCoordinates(Scanner scanner){
        Double x;
        Float y;
        while(true) {
            if (scanner.hasNextDouble()) {
                x = scanner.nextDouble();
                break;
            }
            else{
                System.out.println("Это не число");
                scanner.next();
            }
        }
        while (true) {
            if (scanner.hasNextFloat()) {
                y = scanner.nextFloat();
                break;
            }
            else{
                System.out.println("Это не число");
                scanner.next();
            }
        }
        if (x == null || y == null){
                System.out.println("Ошибка, поля \"координаты фильма\" не могут быть пустыми");
            }
            else {
        this.coordinates = new Coordinates(x, y);
            }
    }

    public enum MovieGenre {
        ACTION,
        DRAMA,
        TRAGEDY;
    }

    public void createMovieGenre(Scanner scanner){
        while(true){
            String movieGenre = scanner.next();
            try {
                if (movieGenre.equals("")) {
                    System.out.println("Ошибка, поле \"жанр\" не может быть пустым");
                } else {
                    this.genre = MovieGenre.valueOf(movieGenre);
                    break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("Такого жанра не существует");
            }
        }
    }

    public enum MpaaRating {
        G,
        PG,
        R,
        NC_17;
    }

    public void createMpaaRating(Scanner scanner){
        while(true){
            try {
                String mpaaRating = scanner.next();
                if (mpaaRating == null) {
                    System.out.println("Ошибка, поле \"название рейтинга\" не может быть пустым");
                } else {
                    this.mpaaRating = MpaaRating.valueOf(mpaaRating);
                    break;
                }
            } catch(IllegalArgumentException e){
                System.out.println("Такого рейтинга не существует");
            }
        }
    }

    public void createOscarsCount(Scanner scanner){
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
            Long oscarsCount = scanner.nextLong();
            if (oscarsCount == null || oscarsCount.intValue() <= 0){
                System.out.println("Ошибка, " +
                        "поле \"количество оскаров\" не может быть пустым и должно быть больше нуля");
            }
            else{
                this.oscarsCount = oscarsCount;
                break;
            }
        }
    }

    public void createName(Scanner scanner){
        while(true){
            String name = scanner.next();
            if (name == null || name.equals("")){
                System.out.println("Ошибка, поле \"название фильма\" не может быть пустым");
            }
            else{
                this.name = name;
                break;
            }
        }
    }

    public void createPerson(Person person){
        while(true){
            if (person == null){
                System.out.println();
            }
            else{
                this.operator = person;
                break;
            }
        }
    }

    public void createMovie(Scanner scanner){
        createId();
        createDate();

        System.out.println("Введите название фильма: ");
        createName(scanner);

        System.out.println("Введите координаты фильма: ");
        createCoordinates(scanner);

        System.out.println("Введите кол-во премий Оскара: ");
        createOscarsCount(scanner);

        System.out.println("Введите жанр фильма: "
                + Arrays.toString(MovieGenre.values()));
        createMovieGenre(scanner);

        System.out.println("Введите рейтинг фильма: " +
                Arrays.toString(MpaaRating.values()));
        createMpaaRating(scanner);

        System.out.println("Теперь заполним информацию, связанную с Режиссером");
        Person person = new Person();

        System.out.println("Введите имя автора фильма: ");
        person.createName(scanner);

        System.out.println("Введите рост автора фильма: ");
        person.createHeight(scanner);

        System.out.println("Введите цвет глаз автора фильма: " +
                Arrays.toString(Person.Color.values()));
        person.createColor(scanner);

        System.out.println("Введите родную страну автора фильма: " +
                Arrays.toString(Person.Country.values()));
        person.createCountry(scanner);

        System.out.println("Введите координаты автора фильма: ");
        person.createLocation(scanner);
        createPerson(person);
    }
}
