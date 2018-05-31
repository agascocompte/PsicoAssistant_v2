package servlet;

import com.google.api.client.json.Json;
import com.google.cloud.dialogflow.v2.WebhookResponse;
import com.google.gson.Gson;
import model.RequestBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

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


        Gson gson = new Gson();
        RequestBridge request = gson.fromJson(req.getReader(), RequestBridge.class);


        String answer = "{" + '"' + "fulfillmentText" + '"' + ":" + '"' + "This is a text response" + '"' + "," +
                '"' + "fulfillmentMessages" + '"' + ": []," +
                '"' + "source" + '"' + ":" + '"' + "example.com" + '"' + "," +
                '"' + "payload" + '"' + ":" + "{}," +
                '"' + "outputContexts" + '"' + ":[]," +
                '"' + "followupEventInput" + '"' + ":{}}";


        WebhookResponse answer2 = WebhookResponse.newBuilder()
                .setFulfillmentText("hey!")
                .build();
        String json = gson.toJson(answer2);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        /*ServletOutputStream out = resp.getOutputStream();
        out.write(answer.getBytes());
        out.flush();
        out.close();*/


        resp.setContentType("application/json");
        //resp.getWriter().write(answer);
        resp.getWriter().write(json);
    }
}

