import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Ship> ships = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readInt("Выберите пункт меню: ", 1, 5);

            switch (choice) {
                case 1:
                    addElement();
                    break;
                case 2:
                    removeElement();
                    break;
                case 3:
                    printAllElements();
                    break;
                case 4:
                    compareElements();
                    break;
                case 5:
                    System.out.println("Завершение работы приложения.");
                    break;
                default:
                    System.out.println("Ошибка выбора.");
            }
        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== МЕНЮ =====");
        System.out.println("1. Добавить новый элемент");
        System.out.println("2. Удалить элемент по индексу");
        System.out.println("3. Вывод всех элементов");
        System.out.println("4. Сравнение двух элементов на равенство");
        System.out.println("5. Завершение работы приложения");
    }

    private static void addElement() {
        System.out.println();
        System.out.println("Выберите тип корабля:");
        System.out.println("1. Пароход");
        System.out.println("2. Парусник");
        System.out.println("3. Корвет");

        int type = readInt("Ваш выбор: ", 1, 3);

        int id = readInt("Введите id корабля от 1 до 100000: ", 1, 100000);
        String name = readString("Введите название корабля: ");

        switch (type) {
            case 1:
                String fuelType = readString("Введите тип топлива: ");
                int enginePower = readInt("Введите мощность двигателя от 1 до 100000: ", 1, 100000);

                ships.add(new Steamship(id, name, fuelType, enginePower));
                break;

            case 2:
                String sailMaterial = readString("Введите материал парусов: ");
                double sailArea = readDouble("Введите площадь парусов от 1 до 10000: ", 1, 10000);

                ships.add(new Sailboat(id, name, sailMaterial, sailArea));
                break;

            case 3:
                String weaponSystem = readString("Введите систему вооружения: ");
                int crewCount = readInt("Введите численность экипажа от 1 до 1000: ", 1, 1000);

                ships.add(new Corvette(id, name, weaponSystem, crewCount));
                break;

            default:
                System.out.println("Ошибка выбора типа корабля.");
        }

        System.out.println("Элемент успешно добавлен.");
    }

    private static void removeElement() {
        if (ships.isEmpty()) {
            System.out.println("Коллекция пуста. Удалять нечего.");
            return;
        }

        printAllElements();

        int index = readInt("Введите индекс элемента для удаления: ", 0, ships.size() - 1);
        ships.remove(index);

        System.out.println("Элемент успешно удален.");
    }

    private static void printAllElements() {
        if (ships.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        System.out.println();
        System.out.println("Список элементов:");

        for (int i = 0; i < ships.size(); i++) {
            System.out.println("[" + i + "] " + ships.get(i));
        }
    }

    private static void compareElements() {
        if (ships.size() < 2) {
            System.out.println("Для сравнения нужно минимум два элемента.");
            return;
        }

        printAllElements();

        int firstIndex = readInt("Введите индекс первого элемента: ", 0, ships.size() - 1);
        int secondIndex = readInt("Введите индекс второго элемента: ", 0, ships.size() - 1);

        Ship firstShip = ships.get(firstIndex);
        Ship secondShip = ships.get(secondIndex);

        if (firstShip.equals(secondShip)) {
            System.out.println("Элементы равны.");
        } else {
            System.out.println("Элементы не равны.");
        }
    }

    private static String readString(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Ошибка: строка не может быть пустой.");
        }
    }

    private static int readInt(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("Ошибка: число должно быть в диапазоне от " + min + " до " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести целое число.");
            }
        }
    }

    private static double readDouble(String message, double min, double max) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                double value = Double.parseDouble(input);

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("Ошибка: число должно быть в диапазоне от " + min + " до " + max + ".");
            } catch (NumberFormatException e) {
    System.out.println("Ошибка: число слишком большое или введено не целое число.");
            }
        }
    }
}
