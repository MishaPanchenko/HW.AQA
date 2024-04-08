package Animal;

public class Food {
    public String name;
    public int appetite;
    public boolean fullness;

    public Food(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Bowl bowl) {
        if (bowl.decreaseFood(appetite)) {
            fullness = true;
            System.out.println(name + " поел и наелся");
        } else {
            System.out.println(name + " не смог наесться");
        }
    }

    public boolean isFull() {
        return fullness;
    }
}
