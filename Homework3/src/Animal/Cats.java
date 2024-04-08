package Animal;


public class Cats extends Animals {
    private static int count;

    public Cats(int runMaxDistance, int swimMaxDistance) {
        super(runMaxDistance, swimMaxDistance);

        count++;
    }
    public static int getCount() {

        return count;
    }



}


