package servlet;

import com.google.cloud.dialogflow.v2.WebhookProto;
import com.google.cloud.dialogflow.v2.WebhookResponse;
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

        logger.info(gson.toJson(request));
        logger.info("Entro aquí");
        System.out.println(gson.toJson(request));

        WebhookResponse webhookResponse = WebhookResponse.newBuilder().build();

        ServletOutputStream out = resp.getOutputStream();
        out.write(gson.toJson(webhookResponse).getBytes());
        out.flush();
        out.close();
    }
}
