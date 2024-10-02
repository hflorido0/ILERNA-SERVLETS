package service;

import dao.PlatosDao;
import model.Plato;
import servlets.PlatosServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PlatosService {
    private PlatosDao platosDao;

    public PlatosService() {
        this.platosDao = new PlatosDao();
    }

    public void getPlatos(HttpServletRequest req, HttpServletResponse resp, PlatosServlet platosServlet) throws ServletException, IOException {
        try {
            ArrayList<Plato> platos = new ArrayList<>();

            this.platosDao.connect();

            platos =  this.platosDao.getAllPlatos();

            req.setAttribute("platos", platos);

            this.platosDao.disconnect();

            for (Plato p : platos) {
                System.out.println(p);
            }

            platosServlet.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        } catch (Exception e) {

            req.setAttribute("error", e.getMessage());
            platosServlet.getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
    }

    public void postPlatos(HttpServletRequest req) {
        System.out.println("HELLO WORLD DESDE POST PLATOS");
    }
}
