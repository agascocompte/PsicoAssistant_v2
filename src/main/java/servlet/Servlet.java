package servlet;

import com.google.cloud.dialogflow.v2.WebhookResponse;
import com.google.gson.Gson;
import model_request.RequestBridge;
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

        // Read request
        Gson gson = new Gson();
        RequestBridge request = gson.fromJson(req.getReader(), RequestBridge.class);



        Map<String, Integer> valor = request.getQueryResult().getParameters();




        // Prepare response
        WebhookResponse response = WebhookResponse.newBuilder()
                .setFulfillmentText("El parámetro anterior es " + valor.get("any"))
                .build();

        ResponseBridge bridge = new ResponseBridge();
        bridge.setFulfillmentText(response.getFulfillmentText());

        String responseJson = gson.toJson(bridge);


        // Send response
        resp.setContentType("application/json");
        resp.getWriter().write(responseJson);
    }
}

