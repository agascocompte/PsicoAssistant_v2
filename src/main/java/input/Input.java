package input;

import java.util.Map;

public class Input {

    public static int calculateScore(Map<String, String> params) {
        int suma = 0;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            suma += Integer.valueOf(entry.getValue());
        }

        return suma;
    }

    public static boolean checkUserInput(String input) {
        boolean isCorrectNumber = false;

        if (input.length() == 1 && input.charAt(0) >= '0' && input.charAt(0) <= '5')
            isCorrectNumber = true;

        return isCorrectNumber;
    }

    public static String isWritenNumber(String text) {
        String answer = "";
        text = text.toLowerCase();
        switch(text) {
            case "cero":
                answer = "0";
                break;
            case "uno":
                answer = "1";
                break;
            case "dos":
                answer = "2";
                break;
            case "tres":
                answer = "3";
                break;
            case "cuatro":
                answer = "4";
                break;
            case "cinco":
                answer = "5";
                break;
            default:
                answer = text;
        }
        return answer;
    }
}
