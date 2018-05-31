package servlet;

import com.google.gson.Gson;
import model.RequestBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
                '"' + "fulfillmentMessages" + '"' + ": [" +
                "{" +
                '"' + "card" + '"' + ":{" +
                '"' + "title" + '"' + ":" + '"' + "card title" + '"' + "," +
                '"' + "subtitle" + '"' + ":" + '"' + "card text" + '"' + "," +
                '"' + "imageUri" + '"' + ":" + '"' + "https://assistant.google.com/static/images/molecule/Molecule-Formation-stop.png" + '"' + "," +
                '"' + "buttons" + '"' + ":[" +
                "{" +
                    '"' + "text" + '"' + ":" + '"' + "button text" + '"' + "," +
                    '"' + "postback" + '"' + ":" + '"' + "https://assistant.google.com/" + '"' + "}]}}]," +
                '"' + "source" + '"' + ":" + '"' + "example.com" + '"' + "," +
                '"' + "payload" + '"' + ":" + "{" +
                    '"' + "google" + '"' + ":" + "{" +
                        '"' + "expectUserResponse" + '"' + ":" + "true" + "," +
                        '"' + "richResponse" + '"' + ":" + "{" +
                        '"' + "items" + '"' + ":" + "[{" +
                            '"' + "simpleResponse" + '"' + ":{" +
                            '"' + "textToSpeech" + '"' + ":" + '"' + "this is a simple response" + '"' + "}}]}}," +
                '"' + "facebook" + '"' + ":{" +
                    '"' + "text" + '"' + ":" + '"' + "Hello, Facebook!" + '"' + "}," +
                '"' + "slack" + '"' + ":{" +
                    '"' + "text" + '"' + ":" + '"' + "This is a simple response for Slack." + '"' + "}}," +
                '"' + "outputContexts" + '"' + ":[{" +
                    '"' + "name" + '"' + ":" + '"' + "projects/v2assistant-203609/agent/sessions/825413e9-2fb4-4179-8344-2650c360acff/contexts/context name" + '"' + "," +
                    '"' + "lifespanCount" + '"' + ":" + "5" + "," +
                    '"' + "parameters" + '"' + ":{" +
                '"' + "param" + '"' + ":" + '"' + "paramValue" + '"' + "}}]," +
                    '"' + "followupEventInput" + '"' + ":{" +
                         '"' + "name" + '"' + ":" + '"' + "eventName" + '"' + "," +
                        '"' + "languageCode" + '"' + ":" + '"' + "en-US" + '"' + "," +
                '"' + "parameters" + '"' + ":{" +
                '"' + "param" + '"' + ":" + '"' + "paramValue" + '"' + "}}}";


        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        ServletOutputStream out = resp.getOutputStream();
        out.write(answer.getBytes());
        out.flush();
        out.close();
    }
}

