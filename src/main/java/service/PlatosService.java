package service;

import dao.PlatosDao;
import model.Plato;
import model.Usuario;
import servlets.PlatosServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
            platosServlet.getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
    }

    public void postPlatos(HttpServletRequest req, HttpServletResponse resp, PlatosServlet platosServlet) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Usuario usuario = (Usuario) session.getAttribute("user");
            if (usuario != null) {
                //TODO: enviar al DAO la reserva con el id_usuario
                int id = usuario.getId();
                Plato plato = new Plato(); //ESTO VIENE DEL FORM DEL JSP O POSTMAN
                this.platosDao.insertPlato(id, plato);
            } else {
                req.setAttribute("error", "Usuario no encontrado.");
                platosServlet.getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
                //otra opcion: enviar a login.jsp
            }
            System.out.println("HELLO WORLD DESDE POST PLATOS");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
            platosServlet.getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
    }
}
