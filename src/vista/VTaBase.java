package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import controlador.CTaBase;

public class VTaBase extends JInternalFrame implements ITaBase, ActionListener {
	
	private JLabel titulo;
	private JTable tabla;
	private DefaultTableModel model; 
	private ResultSet rs=null;
	private String name; 
	private JButton bImprimir;
	private String sql = "SELECT marca, modelo, anno, vehiculo.idvehiculo FROM vehiculomarca, vehiculo, vehiculomodelo WHERE vehiculomodelo.idmodelove = vehiculo.idmodelo and vehiculomodelo.idmarcave = vehiculomarca.idmarcave and vehiculomarca.borrado =false and vehiculomodelo.borrado= false and vehiculo.borrado=false order by vehiculomarca.marca ASC";
	private String sql2 = "SELECT idproducto, caucho.idcaucho as idcaucho, cantidad, alto, ancho, rin, caucho.tipo as tipo, marca.nombre as nombre FROM caucho, producto, marca WHERE producto.idcaucho = caucho.idcaucho and marca.idmarca = producto.idmarca and caucho.borrado =false and producto.borrado = false and marca.borrado= false order by producto.precio ASC";
	private String sql3 = "SELECT nombre, contacto, telefono, rif, idmarca FROM marca WHERE marca.borrado = false order by marca.nombre ASC";
	private String sql4 = "SELECT caucho.idcaucho as idcaucho, marca, modelo, anno, alto, ancho, rin, tipo FROM vehiculomarca, vehiculo, vehiculomodelo, caucho WHERE vehiculomodelo.idmodelove = vehiculo.idmodelo and vehiculomodelo.idmarcave = vehiculomarca.idmarcave and caucho.idcaucho = vehiculo.idcaucho and vehiculomarca.borrado =false and vehiculomodelo.borrado= false and vehiculo.borrado=false and caucho.borrado = false order by modelo ASC";
	private String sql5 = "SELECT idproducto, caucho.idcaucho as idcaucho, precio, alto, ancho, rin, caucho.tipo as tipo, marca.nombre as nombre FROM caucho, producto, marca WHERE producto.idcaucho = caucho.idcaucho and marca.idmarca = producto.idmarca and caucho.borrado =false and producto.borrado = false and marca.borrado= false order by producto.precio ASC";
	private String s = " / ";
	private String real = "";
	private CTaBase controlador;
	
	public VTaBase (String name){
	
	super("Reporte de" + name.toLowerCase());
	this.setSize(700, 400);
	this.setClosable(true);
	this.setIconifiable(true);
	this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	
	this.name=name;
	
	titulo= new JLabel("REPORTE DE " + name, JLabel.CENTER);
	titulo.setFont(new Font("Arial", Font.BOLD, 20));
	
	this.add(titulo, BorderLayout.NORTH);
	
	tabla= new JTable();
	model= new DefaultTableModel();
	tabla.setModel(model);
	
	this.add(new JScrollPane(tabla), BorderLayout.CENTER);
	
	JPanel pboton= new JPanel();
	bImprimir= new JButton("Imprimir");
	bImprimir.addActionListener(this);
	pboton.add(bImprimir);
	this.add(pboton, BorderLayout.SOUTH);
	
	}

public void setControlador(CTaBase c) {
	this.controlador = c;
	}

public void setConsulta(ResultSet rs) {
	this.rs=rs;
	}

public String getOrders () {
	if (name =="ALMACEN") {
		real=sql2;
		}
	else if (name =="VEHÍCULOS") {
	real = sql;
	}
	else if (name =="MARCAS") {
		real = sql3;
		}
	else if (name =="AUTOS/CAUCHOS") {
		real = sql4;
		}
	else if (name =="PRODUCTOS") {
		real = sql5;
		}
	return real;}

public void limpiarTabla () {int filas=tabla.getRowCount();
for(int i=0; i<filas;i++)
	model.removeRow(0);}

public void desplegar() {
	// TODO Auto-generated method stub
	controlador.actionPerformed(new ActionEvent(this, 1, ITaBase.CONSULTA));
	this.limpiarTabla ();
	
	Object[] fila;
	
	if (name =="ALMACEN") {
		model.addColumn("COD");
		model.addColumn("Cantidad");
		model.addColumn("Cedidas");
		model.addColumn("Tipo");
		model.addColumn("Marca");
		
try {
			while(rs.next()) { 
				Object lindo = rs.getObject("ancho") + s + rs.getObject("alto") + s + rs.getObject("rin");
				
				
				fila= new Object[5];
				
				fila[0]= rs.getObject("idproducto");
				fila[1]= rs.getObject("cantidad");
				fila[2]= lindo;
				fila[3]= rs.getObject("tipo");
				fila[4]= rs.getObject("nombre");
				model.addRow(fila);
			}
}  catch (SQLException e) {
			// añadir longitud de tablas y todo eso, si total estoy en esto.
			e.printStackTrace();
}}
		
		
	else if (name =="VEHÍCULOS") {
	try {
		model.addColumn("COD");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Año");
		while(rs.next()) {
			fila= new Object[4];
			fila[0]= rs.getObject("idvehiculo");
			fila[1]= rs.getObject("marca");
			fila[2]= rs.getObject("modelo");
			fila[3]= rs.getObject("anno");
			model.addRow(fila);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	else if (name =="MARCAS") {
		try {
			model.addColumn("COD");
			model.addColumn("Proveedor");
			model.addColumn("Contacto");
			model.addColumn("Teléfono");
			model.addColumn("RIF");
			
			while(rs.next()) {
				fila= new Object[5];
				
				fila[0]= rs.getObject("idmarca");
				fila[1]= rs.getObject("nombre");
				fila[2]= rs.getObject("contacto");
				fila[3]= rs.getObject("telefono");
				fila[4]= rs.getObject("rif");
				model.addRow(fila);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	else if (name =="AUTOS/CAUCHOS") {
		try {model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Año");
		model.addColumn("Medidas");
		model.addColumn("Tipo");
		model.addColumn("COD-Caucho");
			while(rs.next()) {
				Object lindo = rs.getObject("ancho") + s + rs.getObject("alto") + s + rs.getObject("rin");
				fila= new Object[6];
				fila[0]= rs.getObject("marca");
				fila[1]= rs.getObject("modelo");
				fila[2]= rs.getObject("anno");
				fila[3]= lindo;
				fila[4]= rs.getObject("tipo");
				fila[5]= rs.getObject("idcaucho");
				model.addRow(fila);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	else if (name =="PRODUCTOS") {
		model.addColumn("precio");
		model.addColumn("medidas");
		model.addColumn("tipo");
		model.addColumn("marca");
		model.addColumn("código");
		try {
			while(rs.next()) { 
				Object lindo = rs.getObject("ancho") + s + rs.getObject("alto") + s + rs.getObject("rin");
				
				
				fila= new Object[5];
				
				fila[0]= rs.getObject("precio");
				fila[1]= lindo;
				fila[2]= rs.getObject("tipo");
				fila[3]= rs.getObject("nombre");
				fila[4]= rs.getObject("idproducto");
				model.addRow(fila);
			}
} catch (SQLException e) {
			// añadir longitud de tablas y todo eso, si total estoy en esto.
			e.printStackTrace();
}}}

public void actionPerformed(ActionEvent e) {
	try {
		tabla.print();
	} catch (PrinterException e1) {
		e1.printStackTrace();
	}
}	


}

/*this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);*/

/*public void internalFrameActivated(InternalFrameEvent e) {
this.limpiarTabla();
this.desplegar();

}

@Override
public void internalFrameClosed(InternalFrameEvent e) {


}

@Override
public void internalFrameClosing(InternalFrameEvent e) {
this.setVisible(false);
}

@Override
public void internalFrameDeactivated(InternalFrameEvent e) {
// TODO Auto-generated method stub

}

@Override
public void internalFrameDeiconified(InternalFrameEvent e) {
// TODO Auto-generated method stub

}

@Override
public void internalFrameIconified(InternalFrameEvent e) {
// TODO Auto-generated method stub

}

@Override
public void internalFrameOpened(InternalFrameEvent e) {
// TODO Auto-generated method stub

}*/


	/*
public void mostrar (ArrayList <String> NombreC, int Columnas) {
	controlador.actionPerformed(new ActionEvent(this, 1, ITaBase.CONSULTA));
	
	int a=0; 

	while (a<Columnas) {model.addColumn(NombreC.get(a));
	a++;}
	
	Object [] fila;
this.limpiarTabla();

try {
	while(rs.next()) {
	}
		fila= new Object [Columnas];
		for (int i=0; i<Columnas; i++) {fila[i]= rs.getObject(NombreC.get(i));}
		model.addRow(fila);
	}
 catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();}
}



 posible uso para cuando lo haga más indirecto  
 public String getState2 (ArrayList <String> NombreC, int Columnas) {
	int i = 0;
	String todas = "";
	while (i<Columnas) {
	todas= todas + ", " + NombreC.get(i);
	sql2 = "SELECT" + todas + " FROM " + name + " WHERE borrado=false";
	i++;
	}}
	return sql2;
	
	Nota para luego, filtrarlas por tener id y luego ponerlas en un objeto separado que no haga nada puede ser una solución 
	
	
	
	public String getName () {return name;};
	*/
	/*private int seleccion;
	  
	  public void arrancar() {
	this.setVisible(true);
	controlador.actionPerformed(new ActionEvent(this, 1, ITaBase.CONSULTA));
	}*/





