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
        name = "MyServlet", 
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

        ServletOutputStream out = resp.getOutputStream();
        out.write("hello heroku".getBytes());
        out.flush();
        out.close();
    }
    
}