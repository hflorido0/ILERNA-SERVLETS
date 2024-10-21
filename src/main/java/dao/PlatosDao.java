package dao;

import model.Plato;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;

public class PlatosDao extends DaoConnexion {

    public static final String GET_ALL_PLATOS = "Select id, nombre, variedad from Platos";


    public ArrayList<Plato> getAllPlatos() throws SQLException {
        ArrayList<Plato> platos = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(this.GET_ALL_PLATOS);

        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Plato plato = new Plato(
                    rs.getInt("id"),
                    rs.getString(2),
                    rs.getString("variedad"));

            platos.add(plato);
        }
        return platos;


    }

    public void insertPlato(int id_usuario, Plato plato) {
        //TODO: insert into plato (......, id_usuario_creador) values (....., id_usuario);
    }
}
