package fergie.me.Commands;

import fergie.me.CollectionManager;

public class RemoveHead extends CollectionCommand implements Command {
    String description = "remove_head : вывести первый элемент коллекции и удалить его";

    public RemoveHead(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute() {
        try {
            collectionManager.removeHead();
            System.out.println("Первый элемент коллекции удален.");
        } catch (NullPointerException e) {
            System.out.println("В коллекции нет элементов.");
        }
    }

    public String getDescription() {
        return description;
    }
}
