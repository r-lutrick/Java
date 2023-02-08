
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> output = new ArrayList<Integer>();
        Random val = new Random();
        for (int i = 0; i < 10; i++) {
            output.add(val.nextInt(1,20));
        }
        return output;
    }
}
