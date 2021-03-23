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

    public ArrayList<String> get(String surname){
        return book.get(surname);
    }

    public void find(String surname){
        ArrayList<String> result = get(surname);
        if(result != null){
            String mess = String.format("По запросу '%s' найдены следующие номера:", surname);
            System.out.println(mess);
            for (String phone : result){
                System.out.println(phone);
            }
        } else {
            String mess = String.format("Записей с фамилией '%s' не найдено", surname);
            System.out.println(mess);
        }

    }
}
