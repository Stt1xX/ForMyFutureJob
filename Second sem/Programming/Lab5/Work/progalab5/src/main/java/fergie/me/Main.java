package fergie.me;
import java.util.Scanner;


/**
 * The project takes user input and implements collection management commands.
 * @author FergieDoigrales/St1xXx
 * @version 0.1
 */

public class Main {
    public static void main(String[] args) {
        String[] arg;
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new FileManager().importFromFile();
        CommandManager commandManager = new CommandManager(collectionManager, scanner);
        while (true) {
            String s = (scanner.nextLine());
            arg = s.split("\s+");
            if (arg.length == 1) {
                if (s.equals("exit")) {
                    break;
                }
                try {
                    commandManager.getCommands().get(s).execute();
                } catch (NullPointerException e) {
                    System.out.println("Введенной команды не существует.");
                }
            } else
                System.out.println("Слишком длинная команда.");
        }
    }
}