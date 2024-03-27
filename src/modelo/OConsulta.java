package modelo;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class OConsulta {
	private MConsulta ccons = null;
	
	public OConsulta(){
		
	}
	public String crear(MConsulta ccons){
		int op=0;
		ResultSet rs;
		BdConex bd = new BdConex();
		String cod = "";
		
	/*	rs = bd.consultar("SELECT * FROM caucho WHERE idcaucho="+ccons.getCodigo() + " and borrado = false;");
		System.out.println("Paso por la consulta SQL para crear");*/
					op=bd.ejecutar("INSERT INTO caucho (alto, ancho, rin, tipo) VALUES ("+ccons.getC2()+","+ccons.getC1()+"," + ccons.getC3()+",'"+ ccons.getC4()+"');");
						
						if(op>0) {
							rs=bd.consultar("SELECT * FROM caucho WHERE alto='"+ccons.getC2()+"' AND ancho='"+ccons.getC1()+"' AND rin='"+ccons.getC3()+"' AND tipo='"+ccons.getC4()+"'");
						try {
							rs.beforeFirst();
							rs.next();
							cod=rs.getString("idcaucho");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Se ha registrado el caucho bajo el código "+cod);
						}
						else JOptionPane.showMessageDialog(null, "Error al registrar el caucho");
		bd.desconectar();
		return cod;
	}
	
	public boolean modificar (MConsulta ccons){
		
		int op =0;
		BdConex bd = new BdConex();
		boolean correcto=false;
		
		op = bd.ejecutar ("UPDATE caucho SET alto =" + ccons.getC2()+", ancho="+ccons.getC1()+", rin="+ccons.getC3()+",tipo='"+ccons.getC4()+"' WHERE idcaucho="+ccons.getCodigo());
		
		if(op>0)
			correcto=true;
		bd.desconectar();
		return correcto;
		
	}
	
	public boolean borrar (MConsulta cons){
		
		int op=0;
		BdConex bd = new BdConex();
		boolean correcto=false;
		
		
		op=bd.ejecutar("UPDATE caucho SET borrado = true WHERE idcaucho="+cons.getCodigo());
		if(op>0)
			correcto=true;
		bd.desconectar();
		return correcto;
	}
	
	public MConsulta buscar(int codigo){
		
		ResultSet rs=null;
		BdConex bd = new BdConex();
		MConsulta cconsu = new MConsulta();
		
		rs = bd.consultar("SELECT * FROM caucho WHERE idcaucho="+codigo+" and borrado=false;");
		System.out.println("Paso por la consulta SQL");
		try{
			if(rs.first()){
				
				rs.beforeFirst();
				rs.next();
				cconsu.setC2(rs.getString("alto"));
				cconsu.setC1(rs.getString("ancho"));
				cconsu.setC3(rs.getString("rin"));
				cconsu.setC4(rs.getString("tipo"));
		
		
	}else {
		JOptionPane.showMessageDialog(null, "El registro no existe");
	}
	 }catch(NumberFormatException e){
		 e.printStackTrace();
	 }catch(SQLException e){
		 e.printStackTrace();
	 }
		
		bd.desconectar();
		return cconsu;
		
	
	}

}
