package fergie.me;
import fergie.me.Data.*;
import jakarta.xml.bind.JAXBException;

import javax.management.InvalidAttributeValueException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAttributeValueException, JAXBException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager(collectionManager, scanner);
        Parser parser = new Parser();

//        String fileName = System.getenv("file");
//        try {
//            List<Movie> movies = parser.readFromFile(fileName);
//            collectionManager.addAll(movies);
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл" + fileName + "не найден");
//        } catch (NumberFormatException e) {
//            System.out.println("Н");
//        }
        while (true) {
            try {
                String s = scanner.next();
                scanner.nextLine();

                if (s.equals("exit")) {
                    break;
                }

                commandManager.commands.get(s).execute(); //почему-то не работат addIfMin
            } catch (NullPointerException e) {
                System.out.println("Вы ввели несуществующую команду.");
            }
        }

        //create test film
        Movie movie = new Movie();
        movie.setName("Titanik");
        movie.setGenre(MovieGenre.ACTION);
        movie.setOscarsCount(2L);
        Coordinates coordinates = new Coordinates();
        coordinates.setX(12.);
        coordinates.setY(13f);
        movie.setCoordinates(coordinates);
        movie.setMpaaRating(MpaaRating.NC_17);
        movie.setCreationDate(LocalDate.from(LocalDateTime.now()));
        movie.setId(1L);
        Person person = new Person();
        person.setName("Tim");
        person.setHeight(8L);
        person.setEyeColor(Color.GREEN);
        person.setNationality(Country.FRANCE);
        Location location = new Location();
        location.setName("Avstria");
        location.setX(45);
        location.setY(21);
        location.setZ(12);
        person.setLocation(location);
        movie.setOperator(person);
        //create test film

        FileManager fileManager = new FileManager();
        fileManager.movies.add(movie);
        fileManager.movies.add(movie);
        System.out.println(fileManager.movies.size());
        fileManager.importToFile();
    }
}