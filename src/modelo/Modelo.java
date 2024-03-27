package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Modelo {

    int id;
    String nombre;
    boolean borrado;
    
    public Modelo(int id, String nombre, boolean borrado) {
    	this.id=id;
    	this.nombre=nombre;
    	this.borrado=borrado;
    }
    
    public Modelo() {
    	
    };

    public int getId() {
      return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean getBorrado() {
    	return borrado;
    }
    
    public void setBorrado(boolean borrado) {
    	this.borrado = borrado;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Vector<Modelo> vectorModelo(int idmarca) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Modelo> datos = new Vector<Modelo>();
        Modelo dat = null;
        try {

            String sql = "SELECT * FROM vehiculomodelo WHERE borrado = '0' AND idmarcave=" + idmarca;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Modelo();
            dat.setId(0);
            dat.setNombre("Seleccione modelo");
            datos.add(dat);

            while (rs.next()) {
                dat = new Modelo();
                dat.setId(rs.getInt("idmodelove"));
                dat.setNombre(rs.getString("modelo"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
    
    public Vector<Modelo> vectorModeloVe(int idmarca) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Modelo> datos = new Vector<Modelo>();
        Modelo dat = null;
        try {

            String sql = "SELECT * FROM vehiculomodelo WHERE borrado = '0' AND idmarcave=" + idmarca;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Modelo();
            dat.setId(0);
            dat.setNombre("Seleccione modelo");
            datos.add(dat);

            while (rs.next()) {
                dat = new Modelo();
                dat.setId(rs.getInt("idmodelove"));
                dat.setNombre(rs.getString("modelo"));
                datos.add(dat);
            }
            dat = new Modelo();
            dat.setId(0);
            dat.setNombre("Otro");
            datos.add(dat);
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
