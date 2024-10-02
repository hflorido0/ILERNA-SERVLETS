package service;

import dao.LoginDao;
import model.Usuario;
import servlets.LoginServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginService {
    private LoginDao loginDao;

    public LoginService() {
        this.loginDao = new LoginDao();
    }

    public void login(HttpServletRequest req, HttpServletResponse resp, LoginServlet loginServlet) {
        try {
            String usu = req.getParameter("user");
            String pass = req.getParameter("passwrod");

            this.loginDao.connect();

            Usuario usuario = this.loginDao.login(usu, pass);
            if (usuario.getId() == 0) {
                System.out.println("ERROR!! usuario incorrecto");
                req.setAttribute("error", "ERROR!! usuario incorrecto");
                loginServlet.getServletContext().getRequestDispatcher("index.jsp")
                        .forward(req, resp);
            } else {
                req.setAttribute("usuario", usuario);
                loginServlet.getServletContext().getRequestDispatcher("/jsp/actividades.jsp")
                        .forward(req, resp);
            }
            this.loginDao.disconnect();

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            loginServlet.getServletContext().getRequestDispatcher("/jsp/error.jsp");
        }
    }
}
