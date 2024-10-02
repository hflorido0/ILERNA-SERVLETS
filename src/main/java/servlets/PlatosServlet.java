package servlets;

import service.PlatosService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/platos")
public class PlatosServlet extends HttpServlet {
    private PlatosService platosService;

    public PlatosServlet() {
        platosService = new PlatosService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        platosService.getPlatos(req, resp, this);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        platosService.postPlatos(req);
    }
}
