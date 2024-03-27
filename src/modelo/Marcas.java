package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Marcas {

    int id;
    String nombre;
    boolean borrado;
    
    public Marcas(int id, String nombre, boolean borrado) {
    	this.id=id;
    	this.nombre=nombre;
    	this.borrado=borrado;
    }
    
    public Marcas() {
    	
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

    public Vector<Marcas> vectorMarcas() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Marcas> datos = new Vector<Marcas>();
        Marcas dat = null;
        try {

            String sql = "SELECT * FROM vehiculomarca WHERE borrado = '0'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Marcas();
            dat.setId(0);
            dat.setNombre("Seleccione marca");
            datos.add(dat);

            while (rs.next()) {
                dat = new Marcas();
                dat.setId(rs.getInt("idmarcave"));
                dat.setNombre(rs.getString("marca"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
    
    public Vector<Marcas> vectorMarcasVe() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Marcas> datos = new Vector<Marcas>();
        Marcas dat = null;
        try {

            String sql = "SELECT * FROM vehiculomarca WHERE borrado = '0'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Marcas();
            dat.setId(0);
            dat.setNombre("Seleccione marca");
            datos.add(dat);

            while (rs.next()) {
                dat = new Marcas();
                dat.setId(rs.getInt("idmarcave"));
                dat.setNombre(rs.getString("marca"));
                datos.add(dat);
            }
            dat = new Marcas();
            dat.setId(0);
            dat.setNombre("Otra");
            datos.add(dat);
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
