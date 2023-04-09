package fergie.me.Commands;

import fergie.me.CollectionManager;

import java.util.Scanner;

public class RemoveById extends InputCommand implements Command {
    String description = "remove_by_id id : удалить элемент из коллекции по его id";

    public RemoveById(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);
    }

    public void execute() {
        collectionManager.removeById(scanner);
    }

    public String getDescription() {
        return description;
    }
}
