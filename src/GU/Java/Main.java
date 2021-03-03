package GU.Java;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person[] persons = new Person[5];
        //Ex4
        doTask4(persons);
        //Ex5
        doTask5(persons);
    }

    public static void doTask4(Person[] persons){
        persons[0] = new Person("Иванов Иван", "Директор" ,"director@mail.ru" ,"79123456781" ,100000 ,50);
        persons[1] = new Person("Петров Петр", "Бухгалтер" ,"account@mail.ru" ,"79123456782" ,70000 ,45);
        persons[2] = new Person("Сергеев Сергей", "Менеджер" ,"manager@mail.ru" ,"79123456783" ,60000 ,40);
        persons[3] = new Person("Алексеев Алексей", "Кассир" ,"sales@mail.ru" ,"79123456784" ,50000 ,35);
        persons[4] = new Person("Антонов Антон", "Водитель" ,"driver@mail.ru" ,"79123456785" ,40000 ,30);
    }

    public static void doTask5(Person[] persons){
       for(Person person : persons){
           if(person.getAge() > 40) person.printPerson();
       }
    }
}
