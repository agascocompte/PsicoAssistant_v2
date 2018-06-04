package servlet;

import com.google.gson.Gson;
import input.Input;
import model_request.RequestBridge;
import model_response.Context;
import model_response.ResponseBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "webhook",
        urlPatterns = {"/webhook"}
    )
public class Servlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Servlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String output = "";
        int lifespan = 1;
        Context outputContext = null;

        // Read request
        Gson gson = new Gson();
        RequestBridge request = gson.fromJson(req.getReader(), RequestBridge.class);

        // Logic
        Map<String, Integer> parameters = request.getQueryResult().getParameters();
        String sesion = request.getSession();
        if (parameters.size() > 0) {
            String lastInput = String.valueOf(parameters.get("any"));
            lastInput = Input.isWritenNumber(lastInput);
            boolean correctInput = Input.checkUserInput(lastInput);

            if (correctInput) {
                if (parameters.size() == 5) {
                    int score = Input.calculateScore(parameters);
                    output = "Tu puntuación final es de " + score;
                    //output = "Los parámetros en este punto son: " + parameters.get("any").getClass() + " "; //+ parameters.get("valor1").getClass() + " " + parameters.get("valor2").getClass() + " " + parameters.get("valor3").getClass() + " " + parameters.get("valor4").getClass();
                    outputContext = new Context(sesion + "/contexts/adios", lifespan, parameters);
                }
                else {
                    output = request.getQueryResult().getFulfillmentText();
                    outputContext = new Context(sesion + "/contexts/val" + (parameters.size() + 1), lifespan, parameters);
                }
            }
            else {
                output = "Tu respuesta debe de ser un número entre 0 y 5, ambos incluidos.";
                outputContext = new Context(sesion + "/contexts/val" + parameters.size(), lifespan, parameters);
            }
        }

        // Prepare response
        ResponseBridge bridge = new ResponseBridge();
        bridge.setFulfillmentText(output);
        bridge.addOutputContext(outputContext);

        // Send response
        String responseJson = gson.toJson(bridge);
        resp.setContentType("application/json");
        resp.getWriter().write(responseJson);
    }
}

