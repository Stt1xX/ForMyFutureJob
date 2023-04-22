package fergie.me;

import java.nio.file.InvalidPathException;
import java.util.Scanner;


/**
 * The project takes user input and implements collection management commands.
 *
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
            System.out.print("Введите команду: ");
            String s = (scanner.nextLine());
            arg = s.split("\s+");
                try {
//                    if (arg.length == 2)
////                        commandManager.getCommands().get(arg[0].toLowerCase()).execute(arg[1] + ' ' + arg[2]);
////                    else
////                        commandManager.getCommands().get(s.toLowerCase()).execute("");
                    StringBuilder str = new StringBuilder();
                    for (String value : arg) {
                        str.append(value).append(" ");
                    }
                    if (arg.length > 1)
                        commandManager.getCommands().get(arg[0].toLowerCase()).execute(str.
                                substring(arg[0].length() + 1, str.length() - 1));
                    else
                        commandManager.getCommands().get(arg[0].toLowerCase()).execute("");
                } catch (NullPointerException e) {
                    System.out.println("Введенной команды не существует.");
                } catch (InvalidPathException e){
                    System.out.println("Путь к файлу не должен содержать следующих знаков: * ? < > |");
                } catch (IllegalArgumentException e){
                    System.out.println("Данная команда не имеет аргументов.");
                }
//            } else
//                System.out.println("Слишком длинная команда.");
        }
    }
}