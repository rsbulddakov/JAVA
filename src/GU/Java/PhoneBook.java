package GU.Java;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> book = new HashMap<>();

    public void add(String surname, String phone){
        ArrayList<String> buffer = new ArrayList<>();
        if(book.containsKey(surname)){
            buffer = book.get(surname);
        }
        buffer.add(phone);
        book.put(surname, buffer);
    }

    public void get(String surname){
        ArrayList<String> result = new ArrayList<>();
        if(book.containsKey(surname)){
            String mess = String.format("По запросу '%s' найдены следующие номера:", surname);
            System.out.println(mess);
            result = book.get(surname);
            for (String phone : result){
                System.out.println(phone);
            }
        } else {
            String mess = String.format("Записей с фамилией '%s' не найдено", surname);
            System.out.println(mess);
        }

    }
}
