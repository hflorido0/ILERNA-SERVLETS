package dao;

import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDao extends DaoConnexion{

    public static final String LOGIN = "select id, nombre, apellidos, email from Usario where user = ? and password = ?";

    public Usuario login(String usu, String pass) throws SQLException {
        Usuario usuario = new Usuario();
        PreparedStatement ps = con.prepareStatement(LOGIN);
        ps.setString(1, usu);
        ps.setString(2, pass);

        System.out.println(ps.toString());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setEmail(rs.getString("email"));
        }

        return usuario;

    }
}
