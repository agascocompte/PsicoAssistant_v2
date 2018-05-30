package servlet;

import com.google.cloud.dialogflow.v2.WebhookProto;
import com.google.cloud.dialogflow.v2.WebhookResponse;
import com.google.gson.Gson;
import model.RequestBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
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

        logger.info(gson.toJson(request));
        logger.info("Entro aquí");
        System.out.println(gson.toJson(request));

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
                    '"' + "name" + '"' + ":" + '"' + "projects/${PROJECT_ID}/agent/sessions/${SESSION_ID}/contexts/context name" + '"' + "," +
                    '"' + "lifespanCount" + '"' + ":" + "5" + "," +
                    '"' + "parameters" + '"' + ":{" +
                '"' + "param" + '"' + ":" + '"' + "paramValue" + '"' + "}}]," +
                    '"' + "followupEventInput" + '"' + ":{" +
                         '"' + "name" + '"' + ":" + '"' + "eventName" + '"' + "," +
                        '"' + "languageCode" + '"' + ":" + '"' + "en-US" + '"' + "," +
                '"' + "parameters" + '"' + ":{" +
                '"' + "param" + '"' + ":" + '"' + "paramValue" + '"' + "}}}";


        /*String fulfillment = "";
        BufferedReader reader = new BufferedReader(new FileReader("resources/fulfillment.txt"));
        String line = "";
        while ((line = reader.readLine()) != null ) {
            fulfillment += line;
        }*/


        //WebhookResponse response = WebhookResponse.getDefaultInstance();

        resp.setHeader("Content-Type", "application/json");
        resp.setContentType("application/json");
        ServletOutputStream out = resp.getOutputStream();
        out.write(answer.getBytes());
        out.flush();
        out.close();
    }
}

/*
{
"fulfillmentText": "This is a text response",
"fulfillmentMessages": [
  {
    "card": {
      "title": "card title",
      "subtitle": "card text",
      "imageUri": "https://assistant.google.com/static/images/molecule/Molecule-Formation-stop.png",
      "buttons": [
        {
          "text": "button text",
          "postback": "https://assistant.google.com/"
        }
      ]
    }
  }
],
"source": "example.com",
"payload": {
  "google": {
    "expectUserResponse": true,
    "richResponse": {
      "items": [
        {
          "simpleResponse": {
            "textToSpeech": "this is a simple response"
          }
        }
      ]
    }
  },
  "facebook": {
    "text": "Hello, Facebook!"
  },
  "slack": {
    "text": "This is a text response for Slack."
  }
},
"outputContexts": [
  {
    "name": "projects/${PROJECT_ID}/agent/sessions/${SESSION_ID}/contexts/context name",
    "lifespanCount": 5,
    "parameters": {
      "param": "param value"
    }
  }
],
"followupEventInput": {
  "name": "event name",
  "languageCode": "en-US",
  "parameters": {
    "param": "param value"
  }
}

 */
