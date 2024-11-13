package servlets;

import com.google.gson.Gson;
import model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@WebServlet("/helloworld")
public class HelloController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1,"test","test", "test@test.test"));
        usuarios.add(new Usuario(2,"test2","test2", "test2@test.test"));

        Gson gsonArray = new Gson();

        String jsonResponse = gsonArray.toJson(usuarios);

        // Configuramos el tipo de contenido para la respuesta
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Enviamos el JSON como respuesta
        resp.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getReader().readLine();

        System.out.println(action);

        String[] actions = action.split("#");
        System.out.println(Arrays.toString(actions));

        if (action != null) {

            System.out.println("Acción recibida: " + action);

            // Responder con un mensaje
            Map<String, String> responseData = new HashMap<>();
            responseData.put("response", "Acción procesada: " + action);
            Gson gson = new Gson();
            String jsonResponse = gson.toJson(responseData);

            // Configuramos la respuesta
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(jsonResponse);

        } else {

            // Si no se recibe la acción, enviar error
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Map<String, String> responseData = new HashMap<>();
            responseData.put("error", "ERR");

            Gson gson = new Gson();
            String jsonResponse = gson.toJson(responseData);

            resp.getWriter().write(jsonResponse);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getReader().readLine();

        System.out.println("Acción recibida: " + action);

        if ("delete".equals(action)) {
            //TODO: llamada a eliminar a la base de datos
        }

        // Responder con un mensaje
        Map<String, String> responseData = new HashMap<>();
        responseData.put("message", "Acción procesada: " + action);
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(responseData);

        // Configuramos la respuesta
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }
}