import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String HELP_TEXT = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        final Logger logger = LogManager.getLogger(Main.class);

        while (true) {
            try {
                logger.log(Level.INFO, "Попытка разделить введённые данные на требуемые переменные.");
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                if (tokens[0].equals("add")) {
                    try {
                        logger.log(Level.INFO, "Попытка старта метода addCustomer");
                        executor.addCustomer(tokens[1]);
                    } catch (WrongPhoneNumberException phoneNumberException) {
                        logger.log(Level.INFO, "Ошибка формата номера");
                        logger.log(Level.ERROR, "Неверный формат номера", phoneNumberException);
                        System.out.println("Неверный формат номера.");
                    } catch (WrongEmailException emailException) {
                        logger.log(Level.INFO, "Ошибка формата email");
                        logger.log(Level.ERROR, "Неверный формат email.", emailException);
                        System.out.println("Неверный формат email.");
                    } catch (WrongCountComponentsException componentsException) {
                        logger.log(Level.INFO, "Ошибка количества данных");
                        logger.log(Level.ERROR, "Недостаточно данных.", componentsException);
                        System.out.println("Неверное количество данных.");
                    }
                } else if (tokens[0].equals("list")) {
                    logger.log(Level.INFO, "Вызов списка");
                    executor.listCustomers();
                } else if (tokens[0].equals("remove")) {
                    logger.log(Level.INFO, "Удаление из списка");
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    logger.log(Level.INFO, "Вывод количества записей");
                    System.out.println("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    logger.log(Level.INFO, "Получение списка команд");
                    System.out.println(HELP_TEXT);
                } else {
                    System.out.println(COMMAND_ERROR);
                }
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                logger.log(Level.INFO, "После команды не было данных", arrayIndexOutOfBoundsException);
                System.out.println("Нет данных.");
            }
        }
    }
}
