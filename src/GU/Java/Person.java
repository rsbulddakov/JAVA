package GU.Java;

public class Person {
    public String FIO;
    public String position;
    public String email;
    public String phone;
    public float salary;
    public int age;

    public Person(String FIO, String position, String email, String phone, float salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printPerson() {
        System.out.println("ФИО сотрудника: " + this.FIO);
        System.out.println("Должность: " + this.position);
        System.out.println("E-mail: " + this.email);
        System.out.println("Телефон: " + this.phone);
        System.out.println("Зарплата: " + this.salary);
        System.out.println("Возраст: " + this.age);
        System.out.println();
    }
}
