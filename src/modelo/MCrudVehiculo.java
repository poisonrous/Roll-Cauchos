package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.BdConex;
import modelo.MVehiculo;

public class MCrudVehiculo {
	ResultSet rs=null;
	BdConex bd= new BdConex();
	
	public  MVehiculo buscar(String cod) {
		MVehiculo v= new  MVehiculo();
		bd.abrirConexion();
		rs= bd.consultar("SELECT * FROM vehiculo, vehiculomarca, vehiculomodelo WHERE idvehiculo = " +cod+" AND vehiculomodelo.idmarcave =vehiculomarca.idmarcave and vehiculomodelo.idmodelove= vehiculo.idmodelo and vehiculo.borrado= false and vehiculomodelo.borrado= false and vehiculomarca.borrado= false");
		// SELECT * FROM vehiculo, vehiculomarca, vehiculomodelo WHERE idvehiculo ="1" AND vehiculomodelo.idmarcave =vehiculomarca.idmarcave and vehiculomodelo.idmodelove= vehiculo.idmodelo and vehiculo.borrado= false and vehiculomodelo.borrado= false and vehiculomarca.borrado= false;
		try {
			if(rs.first()) {
				rs.beforeFirst();
				rs.next();
				v.setCodigo(cod);
				v.setModelo(rs.getString("modelo").toUpperCase());
				v.setAnno(rs.getString("anno"));
				v.setMarca(rs.getString("marca").toUpperCase());
				v.setBorrado(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "La ID no esta registrada o el vehiculo fue decontinuado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bd.desconectar();
		return v;
	}
	
	public String crear(int idmar, int idmo, String anno, String marca, String modelo, int caso) {
		int op=0;
		String cod="";
		bd.abrirConexion();
		
		if(caso==1) { //solo hay que agregar el vehículo porque la marca y el modelo ya existen
			if(idmar==0 || idmo==0 || anno.length()==0 )
				JOptionPane.showMessageDialog(null, "Uno o más de los campos estan vacios.");
			else if(anno.length()<4)
				JOptionPane.showMessageDialog(null, "El año debe contener 4 digitos.");
		}
		
		if(caso==2) { //hay que crear el modelo y luego agregarlo al vehículo, la marca ya existe
			if(idmar==0 || modelo.length()==0 || anno.length()==0 )
				JOptionPane.showMessageDialog(null, "Uno o más de los campos estan vacios.");
			else if(anno.length()<4)
				JOptionPane.showMessageDialog(null, "El año debe contener 4 digitos.");
			else {bd.ejecutar("INSERT IGNORE INTO vehiculomodelo (modelo, idmarcave) VALUES ('"+modelo+"','"+idmar+"')");
			ResultSet cr=bd.consultar("SELECT * FROM vehiculomodelo WHERE modelo='"+modelo+"' AND borrado = false");
			try {
				cr.next();
				idmo =cr.getInt("idmodelove");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		
		if(caso==3) { //hay que crear tanto la marca como el modelo, luego agregar el vehículo
			if(marca.length()==0 || modelo.length()==0 || anno.length()==0 )
				JOptionPane.showMessageDialog(null, "Uno o más de los campos estan vacios.");
			else if(anno.length()<4)
				JOptionPane.showMessageDialog(null, "El año debe contener 4 digitos.");
			else {bd.ejecutar("INSERT IGNORE INTO vehiculomarca (marca) VALUES ('"+marca+"')");
		ResultSet sr=bd.consultar("SELECT * FROM vehiculomarca WHERE marca='"+marca+"' AND borrado = false");
		try {
			sr.next();
			idmar =sr.getInt("idmarcave");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bd.ejecutar("INSERT INTO vehiculomodelo (modelo, idmarcave) VALUES ('"+modelo+"','"+idmar+"')");
		ResultSet cr=bd.consultar("SELECT * FROM vehiculomodelo WHERE modelo='"+modelo+"' AND borrado = false");
		try {
			cr.next();
			idmo =cr.getInt("idmodelove");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		}
		op=bd.ejecutar("INSERT INTO vehiculo (anno,borrado, idmodelo) VALUES ('"+anno+"',false,'"+idmo+"')");
		if(op>0) {
			rs=bd.consultar("SELECT * FROM vehiculo WHERE anno='"+anno+"' AND idmodelo ='"+idmo+"'");
			try {
				rs.beforeFirst();
				rs.next();
				cod=rs.getString("idvehiculo");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Se ha registrado el vehículo bajo el código " + cod);	
		}else
			JOptionPane.showMessageDialog(null, "Error al registrar el vehiculo.");
		bd.desconectar();
		return cod;
		}
	
	
	public void modificar(String cod, int idmar, int idmo, String anno, String marca, String modelo, int caso) {
		int op=0;
		BdConex bd= new BdConex();
		ResultSet rs=null;
		
		if(caso==1) {
			if(idmar==0 || idmo==0 || anno.length()==0 )
				JOptionPane.showMessageDialog(null, "Uno o más de los campos estan vacios.");
			else if(anno.length()<4)
				JOptionPane.showMessageDialog(null, "El año debe contener 4 digitos.");
		}
		if(caso==2) {
			if(idmar==0 || modelo.length()==0 || anno.length()==0 )
				JOptionPane.showMessageDialog(null, "Uno o más de los campos estan vacios.");
			else if(anno.length()<4)
				JOptionPane.showMessageDialog(null, "El año debe contener 4 digitos.");
			else {
				bd.ejecutar("INSERT INTO vehiculomodelo (modelo, idmarcave) VALUES ('"+modelo+"','"+idmar+"')");
				ResultSet cr=bd.consultar("SELECT * FROM vehiculomodelo WHERE modelo='"+modelo+"' AND borrado = false");
				try {
					cr.next();
					idmo =cr.getInt("idmodelove");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(caso==3) {
			if(marca.length()==0 || modelo.length()==0 || anno.length()==0 )
				JOptionPane.showMessageDialog(null, "Uno o más de los campos estan vacios.");
			else if(anno.length()<4)
				JOptionPane.showMessageDialog(null, "El año debe contener 4 digitos.");
			else {
				bd.ejecutar("INSERT IGNORE INTO vehiculomarca (marca) VALUES ('"+marca+"')");
				ResultSet sr=bd.consultar("SELECT * FROM vehiculomarca WHERE marca='"+marca+"' AND borrado = false");
				try {
					sr.next();
					idmar =sr.getInt("idmarcave");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				bd.ejecutar("INSERT IGNORE INTO vehiculomodelo (modelo, idmarcave) VALUES ('"+modelo+"','"+idmar+"')");
				ResultSet cr=bd.consultar("SELECT * FROM vehiculomodelo WHERE modelo='"+modelo+"' AND borrado = false");
				try {
					cr.next();
					idmo =cr.getInt("idmodelove");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
		op=bd.ejecutar("UPDATE vehiculo SET idmodelo='"+idmo+"', anno='"+anno+"', idcaucho=1 WHERE idvehiculo= "+cod);
		if(op>0) {
			JOptionPane.showMessageDialog(null, "El vehículo fue modificado exitosamente.");}
		else {
			JOptionPane.showMessageDialog(null, "Error al modificar el vehículo.");}
			
		bd.desconectar();
		}
	//if (sr.first()){}
	/* asi va la idea, se crea un ResultSet para exclusivamente marcas (rs1) 
	 * y otro para exclusivamente modelos (rs2) y exclusivamente años (rs3), hago un while rs1.next con 
	if (String pero mayuscula== cada uno de ellos individualmente uno por uno),
	 si pasa por uno conocido se rompe, revisa sus modelos y repite el proceso con while rs2.next sacando solo los modelos
	que coordinen con la id de la marca, se revisan todos los años, si no hay se crea el año nuevo con 
	modelo= el que llevabamos, si hay año, se comprueba si existen años con ese modelo (con busqueda y el clasico rs.first)
	y en caso de que no existan se crea uno nuevo, si hay te avisa que de algun modo pegaste las 3.
	Cosas de las que me di cuenta:
	-El proceso de año se tiene que repetir a pesar de lo que pase con el modelo.
	-El proceso de modelo debería repetirse también aparte de la integridad, aunque que feo.
	
	 */
	
	public void borrar(MVehiculo v) {
		int op=0;
		BdConex bd = new BdConex();
	
		op=bd.ejecutar("UPDATE vehiculo SET borrado=true WHERE idvehiculo="+v.getCodigo());
		if(op>0)
			JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo");
		else
			JOptionPane.showMessageDialog(null, "Error al eliminar el vehículo.");
		bd.desconectar();
	}
}
