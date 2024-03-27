package modelo;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class OMarcaConsulta {
	private MConsulta mcons=null;
	
	
	public OMarcaConsulta(){
		
	}
	public String crear(MConsulta mcons){
		int op=0;
		ResultSet rs=null;
		BdConex bd = new BdConex();
		String cod = "";
		
				op=bd.ejecutar("INSERT INTO marca (nombre, contacto, telefono, rif) VALUES ('"+mcons.getC1()+"','" + mcons.getC2()+"','"+ mcons.getC3()+"','"+mcons.getC4()+"');");
						
					if(op>0) {
						rs=bd.consultar("SELECT * FROM marca WHERE nombre='"+mcons.getC1()+"' AND contacto='"+mcons.getC2()+"' AND telefono='"+mcons.getC3()+"' AND rif='"+mcons.getC4()+"'");
					try {
						rs.beforeFirst();
						rs.next();
						cod=rs.getString("idmarca");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Se ha registrado la marca bajo el código "+cod);
					}
					else JOptionPane.showMessageDialog(null, "Error al registrar la marca");
		
		bd.desconectar();
		return cod;
	}
	
	public boolean modificar (MConsulta mcons){
		
		int op =0;
		BdConex bd = new BdConex();
		boolean correcto=false;
		
		op = bd.ejecutar ("UPDATE marca SET nombre ='" + mcons.getC1()+"', contacto='"+mcons.getC2()+"', telefono='"+mcons.getC3()+"',rif='"+mcons.getC4()+"' WHERE idmarca="+mcons.getCodigo());
		
		if(op>0)
			correcto=true;
		bd.desconectar();
		return correcto;
		
	}


	
	public boolean borrar (MConsulta cons){
		
		int op=0;
		BdConex bd = new BdConex();
		boolean correcto=false;
		
		
		op=bd.ejecutar("UPDATE marca SET borrado = true WHERE idmarca="+cons.getCodigo());
		if(op>0)
			correcto=true;
		bd.desconectar();
		return correcto;
	}
	
	public MConsulta buscar(int codigo){
		
		ResultSet rs=null;
		BdConex bd = new BdConex();
		MConsulta mconsu = new MConsulta();
		
		
		
		rs = bd.consultar("SELECT * FROM marca WHERE idmarca="+codigo+" and borrado=false;");
		System.out.println("Paso por la consulta SQL");
		try{
			if(rs.first()){
				
				rs.beforeFirst();
				rs.next();
				mconsu.setC1(rs.getString("nombre"));
				mconsu.setC2(rs.getString("contacto"));
				mconsu.setC3(rs.getString("telefono"));
				mconsu.setC4(rs.getString("rif"));
		
		
	}else {
		JOptionPane.showMessageDialog(null, "El registro no existe");
	}
	 }catch(NumberFormatException e){
		 e.printStackTrace();
	 }catch(SQLException e){
		 e.printStackTrace();
	 }
		
		bd.desconectar();
		return mconsu;
		
	
	}


}
