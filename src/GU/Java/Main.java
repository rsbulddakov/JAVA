package GU.Java;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivan@mailbox.com", "81234567890", 31000, 30);
        persArray[1] = new Person("Petrov Petr", "Engineer", "petr@mailbox.com", "81234567891", 32000, 45);
        persArray[2] = new Person("Sergeev Sergey", "Engineer", "sergey@mailbox.com", "81234567892", 33000, 35);
        persArray[3] = new Person("Antonov Anton", "Engineer", "anton@mailbox.com", "81234567893", 34000, 42);
        persArray[4] = new Person("Alekseev Aleksey", "Engineer", "aleksey@mailbox.com", "81234567894", 35000, 50);

        for (Person person : persArray) {
            if (person.age > 40) {
                person.printPerson();
            }
        }
    }
}
