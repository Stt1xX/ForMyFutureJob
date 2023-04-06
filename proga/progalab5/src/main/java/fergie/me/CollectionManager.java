package fergie.me;

import fergie.me.Data.Coordinates;
import fergie.me.Data.Location;
import fergie.me.Data.Movie;
import fergie.me.Data.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
@XmlRootElement(name = "storage")
public class CollectionManager {
    protected ArrayDeque<Movie> arrayDeque; // changes: was private;

    private LocalDate initializationDate;

    private long current_id = 1;

    private long currency = 0;

    String className;
    Scanner scanner;

    CollectionManager() {
        initializationDate = LocalDate.now();
        arrayDeque = new ArrayDeque<>();
        className = arrayDeque.getClass().getName();
        currency = arrayDeque.size();
    }

    public void addAll(Collection<Movie> collection) {
        for (Movie movie : collection) {
            movie.setId(current_id);
            arrayDeque.add(movie);
            current_id++;
        }
    }

    public void add(Movie movie) {
        movie.setId(current_id);
        arrayDeque.add(movie);
        current_id++;
        System.out.println("Фильм успешно добавлен.");
        System.out.println("Фильмов в коллекции:" + arrayDeque.size());
    }

    public void clear() {
        this.arrayDeque.clear();
    }

    public boolean checkID(Long id) {
        for (Movie currentMovie : this.arrayDeque) {
            if (currentMovie.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void updateMovie(Movie movie) {
        for (Movie currentMovie : this.arrayDeque) {
            if (currentMovie.getId().equals(movie.getId())) {
                currentMovie = movie;
            }
        }
    }

    public void addIfMin(Movie movie) {
        //Movie minMovie = Collections.min(arrayDeque);
        Movie minMovie = findMin();
        if (movie.compareTo(minMovie) < 0) {
            arrayDeque.add(movie);
        } else
            System.out.println("Выбранный фильм > min.");
    }

    public void removeIfGreater(Movie movie) {
        List<Movie> moviesForDelete = new ArrayList<>();

        for (Movie m: arrayDeque) {
            if (m.compareTo(movie) > 0) {
                moviesForDelete.add(m);
            }
        }

        arrayDeque.removeAll(moviesForDelete);
    }

    public void removeHead() {
        this.arrayDeque.removeFirst();
    }

    public void removeById() {
        System.out.println("Введите id фильма, который необходимо удалить:");
        long id = scanner.nextLong();
        Movie del = null;
        for (Movie currentMovie : this.arrayDeque) {
            if (currentMovie.getId() == id) {
                del = currentMovie;
                //currentMovie = null;
                //System.gc();
            }
        }
        this.arrayDeque.remove(del);
    }

    public int SumOfOscarsCount() {
        int oscars = 0;
        for (Movie movie : this.arrayDeque) {
            oscars += movie.getOscarsCount();
        }
        return oscars;
    }

    public void show() {
        for (Movie movie : arrayDeque) {
            System.out.print(" " + movie.toString() + "\n");
        }
        System.out.println("Коллекция содержит " + arrayDeque.size() + " элементов.");
        if (arrayDeque.size() == 0)
            System.out.println("Коллекция пуста.");
    }
    public Movie findMin(){
        Movie temp = arrayDeque.getFirst();
        for (Movie movie : arrayDeque){
             if (movie.compareTo(temp) < 0)
                temp = movie;
        }
        return temp;
    }
    // создать новую коллекцию без этого элемента
    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    public String getClassName() {
        return this.className;
    }

    public Long getCurrency() {
        return this.currency;
    }


}
