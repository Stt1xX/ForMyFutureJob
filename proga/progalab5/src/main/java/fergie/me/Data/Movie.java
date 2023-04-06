package fergie.me.Data;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import javax.management.InvalidAttributeValueException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
@XmlRootElement
public class Movie implements Comparable<Movie> {
    private Long id; //���� �� ����� ���� null, �������� ���� ������ ���� ������ 0, �������� ����� ���� ������ ���� ����������, �������� ����� ���� ������ �������������� �������������

    private String name; //���� �� ����� ���� null, ������ �� ����� ���� ������
    private Coordinates coordinates; //���� �� ����� ���� null
    private java.time.LocalDate creationDate; //���� �� ����� ���� null, �������� ����� ���� ������ �������������� �������������
    private Long oscarsCount; //�������� ���� ������ ���� ������ 0, ���� �� ����� ���� null
    private MovieGenre genre; //���� �� ����� ���� null
    private MpaaRating mpaaRating; //���� ����� ���� null
    private Person operator; //���� �� ����� ���� null
    //private long Id;

    //private static long nextId = 1L;

    public Movie() {

    }



    public Movie(long id, String name, Coordinates coordinates, java.time.LocalDate creationDate, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator) {
        //setId();
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.operator = operator;
    }

    //    Set<Long> Id = new HashSet<>();
//    // @NotNull
//    public void setId(){
//        if (nextId == Long.MAX_VALUE){
//            this.id = 1L;
//            nextId = 1;
//        }
//        else{
//            this.id = nextId;
//            nextId += 1;
//        }
//        Id.add(this.id);
//    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) throws InvalidAttributeValueException {
        if (name == null || name.equals("")) {
            throw new InvalidAttributeValueException("��� ������ �� ����� ���� ������");
        } else {
            this.name = name;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) throws InvalidAttributeValueException {
        if ((coordinates == null))
            throw new InvalidAttributeValueException("���������� �� ����� ���� null");
        else
            this.coordinates = coordinates;
    }

    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.time.LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(String oscarsCount) throws InvalidAttributeValueException {
        setOscarsCount(Long.parseLong(oscarsCount));
    }

    public void setOscarsCount(Long oscarsCount) throws InvalidAttributeValueException {
        if (oscarsCount == null || oscarsCount == 0)
            throw new InvalidAttributeValueException("���������� ������� �� ����� ������� 0 ��� null");
        this.oscarsCount = oscarsCount;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) throws InvalidAttributeValueException {
        if (genre == null)
            throw new InvalidAttributeValueException("�������� ���� ���� �� ����� ���� null");
        this.genre = genre;
    }

    public MpaaRating getMpaaRating() {
        return this.mpaaRating;
    }

    public void setMpaaRating(MpaaRating mpaaRating) throws InvalidAttributeValueException {
        if (mpaaRating == null)
            throw new InvalidAttributeValueException("�������� ���� MpaaRating �� ����� ���� null");
        this.mpaaRating = mpaaRating;
    }

    public Person getOperator() {
        return this.operator;
    }

    public void setOperator(Person operator) throws InvalidAttributeValueException {
        if (operator == null)
            throw new InvalidAttributeValueException("�������� ���� operator �� ����� ���� null");
        this.operator = operator;
    }

    //�������������� equals hashcode � toString ��� movie
    @Override
    public String toString() {
        return "��������: " + this.name + " | id: " + this.id + " ";
    }

    public static Movie createNewMovie(Scanner scanner) {
        System.out.println("������� ���������.");
        Movie movie = new Movie();

        { // movie: movieGenre, MpaaRating, coordinates
            movie.setCreationDate(LocalDate.from(LocalDateTime.now()));
            System.out.println("������� �������� ������:");
            Checker.Setter checker = () -> {
                        movie.setName(scanner.nextLine());
            };
            Checker.checkData(checker);


            System.out.println("������� ���������� �������:");

            checker = () -> {
                movie.setOscarsCount(scanner.nextLine());
            };
            Checker.checkData(checker);



            System.out.println("�������� �� ������ MpaaRating � ������� ���:"
                    + "\n" + Arrays.toString(MpaaRating.values()));
            checker = () -> {
                movie.setMpaaRating(MpaaRating.valueOf(scanner.nextLine()));
            };
            Checker.checkData(checker);


            System.out.println("�������� ���� �� ������: ");
            System.out.println(Arrays.toString(MovieGenre.values()));
            checker = () -> {
                movie.setGenre(MovieGenre.valueOf(scanner.nextLine()));
            };
            Checker.checkData(checker);

            //coordinates
            {
                Coordinates coordinates = new Coordinates();
                System.out.println("������� ���������� x: ");
                checker = () -> {
                    coordinates.setX(scanner.nextLine()); //������� �������� �� null
                };
                Checker.checkData(checker);
                System.out.println("������� ���������� y: ");
                checker = () -> {
                    coordinates.setY(scanner.nextLine());
                };
                Checker.checkData(checker);

                checker = () -> {
                    movie.setCoordinates(coordinates); //������ ��������
                };
                Checker.checkData(checker);


            }

            { //person
                Person operator = new Person();
                System.out.println("������� ��� ���������:");
                checker = () -> {
                    operator.setName(scanner.nextLine());
                };
                Checker.checkData(checker);

                //color
                System.out.println("�������� ���� ���� ��������� �� ������������ � ������� ���: ");
                System.out.println(Arrays.toString(Color.values()));
                checker = () -> {
                    operator.setEyeColor(Color.valueOf(scanner.nextLine()));
                };
                Checker.checkData(checker);

                //country
                System.out.println("������� �������������� ���������: ");
                System.out.println(Arrays.toString(Country.values()));
                checker = () -> {
                    operator.setNationality(Country.valueOf(scanner.nextLine()));
                };
                Checker.checkData(checker);

                //height
                System.out.println("������� ���� ���������:");
                checker = () -> {
                    operator.setHeight(scanner.nextLine());
                };
                Checker.checkData(checker);

                { //location + coordinates
                    Location location = new Location();
                    System.out.println("������� ��������� ���������� (x,y) ��������� � ������� 0.0 (����� ��� ���������� ���������?????????): ");
                    checker = () -> {
                    location.setX(scanner.nextLine());
                    };
                    Checker.checkData(checker);
                    checker = () -> {
                        location.setY(scanner.nextLine());
                    };
                    Checker.checkData(checker);
                    System.out.println("������� ���������� z ��������� (long): ");
                    checker = () -> {
                    location.setZ(scanner.nextLine());
                    };
                    Checker.checkData(checker);
                    System.out.println("������� �������� �������:");
                    checker = () -> {location.setName(scanner.nextLine());
                    };
                    Checker.checkData(checker);

//                    checker = () -> {
//                        operator.setLocation(location);
//                    };
//                    Checker.checkData(checker);

                }
                checker = () -> {
                    movie.setOperator(operator);
                };
            }
        }
        return movie;
    }

    @Override
    public int compareTo(Movie movie) {
        return Objects.equals(this.getOscarsCount(), movie.getOscarsCount()) ? 0 : this.getOscarsCount().compareTo(movie.getOscarsCount());
    }
}
