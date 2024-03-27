package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Caucho {

    int id;
    String alto, ancho, rin, tipo;
    boolean borrado;
    
    public Caucho(int id, String alto, String ancho, String rin, String tipo, boolean borrado) {
    	this.id=id;
    	this.alto=alto;
    	this.ancho=ancho;
    	this.rin=rin;
    	this.tipo=tipo;
    	this.borrado=borrado;
    }
    
    public Caucho() {
    	
    };


    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlto() {
		return alto;
	}

	public void setAlto(String alto) {
		this.alto = alto;
	}

	public String getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public String getRin() {
		return rin;
	}

	public void setRin(String rin) {
		this.rin = rin;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	@Override
    public String toString() {
		String titulo="";
		if(alto=="")titulo="Seleccione caucho";
		else titulo=ancho+"/"+alto+"/"+rin+"-"+tipo;
        return titulo;
    }

    public Vector<Caucho> vectorCaucho() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Caucho> datos = new Vector<Caucho>();
        Caucho dat = null;
        try {

            String sql = "SELECT * FROM caucho WHERE borrado = '0'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Caucho();
            dat.setId(0);
            dat.setAlto("");
            dat.setAncho("");
            dat.setRin("");
            dat.setTipo("");
            datos.add(dat);

            while (rs.next()) {
                dat = new Caucho();
                dat.setId(rs.getInt("idcaucho"));
                dat.setAlto(rs.getString("alto"));
                dat.setAncho(rs.getString("ancho"));
                dat.setRin(rs.getString("rin"));
                dat.setTipo(rs.getString("tipo"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
