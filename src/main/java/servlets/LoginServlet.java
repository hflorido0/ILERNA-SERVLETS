package servlets;

import com.google.gson.Gson;
import model.Plato;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    public LoginServlet() {
        this.loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();

        List<Plato> reservas = new ArrayList<>();
        reservas.add(new Plato(1, "2024-11-06", "Usuario1"));
        reservas.add(new Plato(2, "2024-11-07", "Usuario2"));

        // Convertir la respuesta a JSON
        String jsonResponse = gson.toJson(reservas);

        // Configurar la respuesta
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Si los datos son enviados como JSON, hay que leer el cuerpo de la solicitud
        String action = req.getReader().readLine();

        System.out.println(action);

        // Aquí puedes hacer algo con el parámetro 'action'
        if (action != null) {
            // Ejemplo: hacer algo dependiendo de la acción
            System.out.println("Acción recibida: " + action);

            // Responder con un mensaje
            Map<String, String> responseData = new HashMap<>();
            responseData.put("message", "Acción procesada: " + action);
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
            responseData.put("error", "No se recibió la acción");

            Gson gson = new Gson();
            String jsonResponse = gson.toJson(responseData);

            resp.getWriter().write(jsonResponse);
        }
    }
}
