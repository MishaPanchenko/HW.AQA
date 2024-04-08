package Animal;


public class Cats extends Animals {
    private static int count;
//    private int appetite;
//    private boolean fullness;


    public Cats(int runMaxDistance, int swimMaxDistance) {
        super(runMaxDistance, swimMaxDistance);

        count++;
    }
    public static int getCount() {

        return count;
    }



}


