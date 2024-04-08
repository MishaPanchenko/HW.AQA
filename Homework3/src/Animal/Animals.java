package Animal;

public abstract class Animals {

    private int runMaxDistance; // Дистанция бега
    private int swimMaxDistance; // Дистанция плавания
    public static int getCount() {

        return count;
    }

    private static int count;
    public Animals(int runMaxDistance, int swimMaxDistance) {
        // Стучимся к самому классу Animal и его поле fullName
        this.runMaxDistance = runMaxDistance;
        this.swimMaxDistance = swimMaxDistance;
        count++;

    }
    public void run(int runDistance) { // Бегать
        System.out.println(runDistance <= runMaxDistance ? " пробежал " + runDistance + "м" : " не может бежать");
    }
    public void swim(int swimDistance) { // Плыть
        System.out.println(swimDistance < swimMaxDistance ? " проплыл " + swimDistance + "м" : " не может плыть");
    }


}
