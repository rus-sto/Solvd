package hw002;

import java.util.Scanner;

public class HW002 {
    /*У каждого своя тема + вопрос
Создать 10 классов (чтобы объекты были связаны)
- Должны быть связи – логика иерархии
- Хотя бы 2 LocalDateTime и 2 Date
- Должны быть разнесены по пакетам (по темам)
- Конструкторы должны быть расставлены корректно
- Хотя бы в 1 из них придумать логичное статическое поле и метод
- кроме getter-ов и setter-ов хотя бы в 3 из них создать простые методы (с возвращаемым типом и без)
- хотя бы в 2 из них перегрузить методы
- заполнить в методе main
- вызвать созданные методы методы (кастомные)
Иерархия обязательно + бизнес вопрос, который можно сделать кустаным способом
(главное мне видеть, что вы понимаете как оперировать над объектами и использование
всяких конструкций как циклы, if-else и тд)
!!!
Моя тема: Строительная компания. (техника, материалы, …)
Вопрос: Сколько времени и денег уйдет на постройку дома
!!!
     */
    public static void main(String[] args) {
        // Принимаем в расчет , что все квартиры в доме и комнаты в квартирах ординаковые. Дом одноподъездный
//Вводим  количество этажей, количество квартир, количество комнат, размер комнат
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of flores");
        int numberOfFlares = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Input number of flats per each flore");
        int flatsPerFlore = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Input number of rooms in each flat");
        int numberOfRooms = scanner2.nextInt();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Input room size (m2)");
        double square = scanner3.nextDouble();

    }
}
