package servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public void helloWorld(HttpServletResponse response) throws IOException {
        // Creamos un mapa con los datos que queremos devolver
        Map<String, String> responseData = new HashMap<>();
        responseData.put("message", "¡Hola, Mundo desde Spring MVC!");

        // Convertimos el mapa a JSON
        String jsonResponse = "{\"message\": \"" + responseData.get("message") + "\"}";

        // Configuramos el tipo de contenido para la respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Enviamos el JSON como respuesta
        response.getWriter().write(jsonResponse);
    }
}