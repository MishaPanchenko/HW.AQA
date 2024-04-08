package Homework;

public class Employees {

    private String fullName;
    private String position;
    private String email;
    private String telNumber;
    private int salary;
    private int age;

    public Employees(String fullName, String position, String email, String telNumber, int salary, int age) {
        setValues(fullName, position, email, telNumber, salary, age);
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telNumber = telNumber;
        this.salary = salary;
        this.age = age;


    }


    public void setValues(String fullName, String position, String email, String telNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telNumber = telNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s \nДолжность: %s \nEmail: %s \nНомер телефона: %s \nЗарплата: %d \nВозраст: %d \n",
                fullName, position, email, telNumber, salary, age);
    }


    public static void main(String[] args) {

        Employees[] array = new Employees[5];
        array[0] = new Employees("Панченко Михаил Андреевич", "Banking Department Coach", "hsakata@mail.ru", "+375443647599", 500, 24);
        array[1] = new Employees("Максименко Наталья Андреевна", "Project manager", "aloha223@mail.ru", "+375291723455", 1000, 24);
        array[2] = new Employees("Шевченко Максим Анатольевич", "Developer", "maximus777@mail.ru", "+375446667275", 10000, 30);
        array[3] = new Employees("Ананьева Елена Ивановна", "HR", "mausi11@mail.ru", "+375258041371", 700, 34);
        array[4] = new Employees("Семченко Андрей Григорьевич", "AQA Engineer", "thebestengine@mail.ru", "+375441243351", 6000, 27);
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
    }

}




