package GU.Java;

public class Person {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public int getAge() {
        return age;
    }

    //task2
    public Person(String fio, String position, String email, String phone, float salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //task3
    public void printPerson(){
        System.out.println("ФИО:" + this.fio);
        System.out.println("Должность:" + this.position);
        System.out.println("Email:" + this.email);
        System.out.println("Телефон:" + this.phone);
        System.out.println("Зарплата:" + this.salary);
        System.out.println("Возраст:" + this.age);
        System.out.println();
    }
}
