package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Connection;

public class Marca {

    int id;
    String nombre;
    boolean borrado;
    
    public Marca(int id, String nombre, boolean borrado) {
    	this.id=id;
    	this.nombre=nombre;
    	this.borrado=borrado;
    }
    
    public Marca() {
    	
    }

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

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
    
    public String toString() {
    	String titulo="";
    	if(nombre=="") titulo="Seleccione marca";
    	else titulo=nombre;
        return titulo;
    }
    
    public Vector<Marca> vectorMarca() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Marca> datos = new Vector<Marca>();
        Marca dat = null;
        try {

            String sql = "SELECT * FROM marca WHERE borrado = '0'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Marca();
            dat.setId(0);
            dat.setNombre("");
            datos.add(dat);

            while (rs.next()) {
                dat = new Marca();
                dat.setId(rs.getInt("idmarca"));
                dat.setNombre(rs.getString("nombre"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
