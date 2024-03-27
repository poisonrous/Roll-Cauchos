package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import modelo.BdConex;


public class OperarMVC {
		
	public Caucho buscar(int idcaucho) {
		BdConex bd= new BdConex();
		ResultSet rs=null;
		Caucho caucho = new Caucho();
		rs=bd.consultar("SELECT * FROM caucho WHERE idcaucho='"+idcaucho+"';");
		
	try {
			rs.beforeFirst();
			rs.next();
			caucho.setAlto(rs.getString("alto"));
			caucho.setAncho(rs.getString("ancho"));
			caucho.setRin(rs.getString("rin"));
			caucho.setTipo(rs.getString("tipo"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return caucho;
	}
	
	public void agregar(int vehiculo, int caucho) {
        
		int op=0;
		BdConex bd= new BdConex();
		
		op=bd.ejecutar("UPDATE vehiculo SET idcaucho='"+caucho+"' WHERE idvehiculo='"+vehiculo+"'");
		if(op>0)
			JOptionPane.showMessageDialog(null, "Se ha registrado el caucho");
		else
			JOptionPane.showMessageDialog(null, "Error al registrar el caucho");
		bd.desconectar();
		
		}
	}
	
