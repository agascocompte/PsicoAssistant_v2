package servlet;


import com.google.cloud.dialogflow.v2.WebhookResponse;
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
    private static final String FINAL_CONTEXT = "adios";

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

        if (parameters.size() == 5) {
            int score = Input.calculateScore(parameters);
            output = "Tu puntuación final es de " + score;
            //contextName = FINAL_CONTEXT;
        }
        else {
            String lastInput = String.valueOf(parameters.get("any"));
            lastInput = Input.isWritenNumber(lastInput);
            boolean correctInput = Input.checkUserInput(lastInput);

            if (correctInput) {
                output = request.getQueryResult().getFulfillmentText();
                //contextName = "val" + (parameters.size() + 1);
            }
            else {
                output = "Tu respuesta debe de ser un número entre 0 y 5, ambos incluidos.";
                outputContext = new Context("val" + parameters.size(), lifespan, parameters);
            }
        }

        // Prepare response
        ResponseBridge bridge = new ResponseBridge();
        bridge.setFulfillmentText("HOLA");
        bridge.addOutputContext(outputContext);


        //bridge.addOutputContext(outputContext);

        // Send response
        String responseJson = gson.toJson(bridge);
        resp.setContentType("application/json");
        resp.getWriter().write(responseJson);
    }
}

