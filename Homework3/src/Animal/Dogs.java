package Animal;

public class Dogs extends Animals {
    private static int count;
    public Dogs(int runMaxDistance, int swimMaxDistance) {
        super(runMaxDistance, swimMaxDistance);
        count ++;
    }
    public static int getCount() {
        return count;
    }
}