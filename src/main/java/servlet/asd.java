package servlet;

import java.util.HashMap;
import java.util.Map;

public class asd {
    public static void main(String[] args) {
        Map<String, Integer> params = new HashMap<>();
        int suma = 0;

        params.put("any", 3);
        params.put("valor1", 1);
        params.put("valor2", 3);
        params.put("valor3", 5);
        params.put("valor4", 3);

        for (Map.Entry<String, Integer> entry : params.entrySet()) {
            if (entry.getKey().equals("any"))
                suma += Integer.valueOf(entry.getValue());
            else
                suma += entry.getValue();
        }

        System.out.println(suma);
    }
}
