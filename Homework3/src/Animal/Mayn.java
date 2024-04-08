package Animal;

public class Mayn {
    public static void main(String[] args) {
        System.out.print("Кот1");
        Animals vaska = new Cats(200, 0);
        vaska.run(145);
        vaska.swim(12);
        System.out.println();

        System.out.println("Кот2");
        Animals roy = new Cats(200, 0);
        roy.run(23);
        roy.swim(0);
        System.out.println();


        System.out.print("Пёс");
        Animals elka = new Dogs(500, 3);
        elka.run(400);
        elka.swim(2);
        System.out.println();

        System.out.println("Количество котов: " + (Cats.getCount()));
        System.out.println("Количество собак: " + (Dogs.getCount()));
        System.out.println("Количество животных: " + (Animals.getCount()));
        System.out.println();


        Food[] cats = new Food[2];
        cats[0] = new Food("Vasya",12);
        cats[1] = new Food("Petya", 40);


    Bowl bowl = new Bowl(20);


        for (Food cat : cats) {
            cat.eat(bowl);
        }
        System.out.println("Сытость котов:");
        for (Food cat : cats) {
            System.out.println(cat.isFull() ? cat.name + " сыт" : cat.name + " голоден");
        }



        bowl.addFood(30);
        System.out.println("Добавили еды в миску. Теперь в миске " + bowl.food + " еды");
    }


}

