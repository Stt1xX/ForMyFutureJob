package fergie.me.Commands;

import fergie.me.CollectionManager;
import fergie.me.Data.Movie;

import java.util.Scanner;

public class AddElement extends InputCommand implements Command {
    String description = "add {element} : добавить новый элемент в коллекцию";

    public AddElement(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);
    }

    public void execute() {

        this.collectionManager.addElement(Movie.createNewMovie(this.scanner));
    }

    public String getDescription() {
        return description;
    }

}
