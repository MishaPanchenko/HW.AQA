package Animal;

public abstract class Animals {

    private int runMaxDistance; 
    private int swimMaxDistance; 
    public static int getCount() {

        return count;
    }

    private static int count;
    public Animals(int runMaxDistance, int swimMaxDistance) {
       
        this.runMaxDistance = runMaxDistance;
        this.swimMaxDistance = swimMaxDistance;
        count++;

    }
    public void run(int runDistance) { 
        System.out.println(runDistance <= runMaxDistance ? " пробежал " + runDistance + "м" : " не может бежать");
    }
    public void swim(int swimDistance) { 
        System.out.println(swimDistance < swimMaxDistance ? " проплыл " + swimDistance + "м" : " не может плыть");
    }


}
