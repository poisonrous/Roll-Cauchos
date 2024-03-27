package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Anno {

    int id, idcaucho;
    String anno;
    boolean borrado;
    
    public Anno(int id, int idcaucho, String nombre, boolean borrado) {
    	this.id=id;
    	this.idcaucho=idcaucho;
    	this.anno=anno;
    	this.borrado=borrado;
    }
    
    public Anno() {
    	
    };

    public int getId() {
      return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdCaucho() {
        return idcaucho;
      }

      public void setIdCaucho(int idcaucho) {
          this.idcaucho = idcaucho;
      }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }
    
    public boolean getBorrado() {
    	return borrado;
    }
    
    public void setBorrado(boolean borrado) {
    	this.borrado = borrado;
    }

    @Override
    public String toString() {
        return anno;
    }

    public Vector<Anno> vectorAnno(int idmodelo) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        BdConex conn = new BdConex();
        Connection con = (Connection) conn.getConexion();

        Vector<Anno> datos = new Vector<Anno>();
        Anno dat = null;
        try {

            String sql = "SELECT * FROM vehiculo WHERE borrado = '0' AND idmodelo=" + idmodelo;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Anno();
            dat.setId(0);
            dat.setAnno("Seleccione año");
            dat.setIdCaucho(0);
            datos.add(dat);

            while (rs.next()) {
                dat = new Anno();
                dat.setId(rs.getInt("idvehiculo"));
                dat.setAnno(rs.getString("anno"));
                dat.setIdCaucho(rs.getInt("idcaucho"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
