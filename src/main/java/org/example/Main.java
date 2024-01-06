package org.example;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args) {
        // Добавление элементов в книгу
        PhoneBook.addContact("Ваня", "1663");
        PhoneBook.addContact("Ваня", "1673");
        PhoneBook.addContact("Ваня", "1683");
        PhoneBook.addContact("Женя", "1763");
        PhoneBook.addContact("Женя", "1773");
        PhoneBook.addContact("Женя", "1783");
        PhoneBook.addContact("Женя", "1793");
        PhoneBook.addContact("Петя", "1863");

        // Вывод телефонной книги
        PhoneBook.printPhoneBook();

    }
}


//task
//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут
// повторяющиеся имена с разными телефонами, их необходимо считать,
// как одного человека с разными телефонами. Вывод должен быть отсортирован по
// убыванию числа телефонов.

class PhoneBook {

    static HashMap<String, List<String>> phoneBook = new HashMap<>();



    public static void addContact(String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void printPhoneBook() {
        // Преобразование HashMap в отсортированный список
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        // Вывод телефонной книги
        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}