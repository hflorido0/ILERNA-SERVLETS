package servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
        // Creamos el objeto ModelAndView
        ModelAndView model = new ModelAndView("hello");

        // Añadimos datos al modelo
        model.addObject("message", "¡Hola, Mundo desde Spring MVC!");

        return model;
    }
}