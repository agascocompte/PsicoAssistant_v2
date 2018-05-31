package input;

import java.util.List;
import java.util.Map;

public class Input {

    public static int calculateScore(Map<String, Integer> params) {
        int suma = 0;

        for (Map.Entry entry : params.entrySet()) {
            suma += (int) entry.getValue();
        }

        return suma;
    }

    public static boolean checkUserInput(String input) {
        boolean isCorrectNumber = false;



        return isCorrectNumber;
    }
}
