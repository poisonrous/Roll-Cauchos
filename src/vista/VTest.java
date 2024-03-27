package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vista.Validacion;
import controlador.CTest;
//import org.apache.commons.text.WordUtils; WordUtils.capitalizeFully(name)

public class VTest extends JInternalFrame implements ITest, ActionListener {
	
	private JTable tabla;
	private JLabel lElegido;
	private DefaultTableModel model;
	private ResultSet rs = null;
	private JButton bImprimir, bBuscar;
	private JTextField tDato;
	private String name;
	private String sql ="";
	private String s = " / ";
	
	public VTest (String name){
		
	super("Consulta de " +name.toLowerCase());
	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	this.setSize(400, 300);
	this.setClosable(true);
	this.setIconifiable(true);
	
	
	this.name = name;	
	Dimension dimcombo = new Dimension(150, 30);
	
	JPanel pBuscar= new JPanel();
	tDato= new JTextField(15);
	tDato.setPreferredSize(dimcombo);
	lElegido = new JLabel (name.toLowerCase() + ":");
	pBuscar.add(lElegido);
	pBuscar.add(tDato);
	bBuscar=new JButton("Buscar");
	bBuscar.setActionCommand(ITest.CONSULTA);
	pBuscar.add(bBuscar);
	this.add(pBuscar, BorderLayout.NORTH);
	
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

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	try {
		tabla.print();
	} catch (PrinterException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

@Override
public void arrancar() {
	this.setVisible(true);
}

@Override
public void setControlador(CTest c) {
	bBuscar.addActionListener(c);
}

@Override
public String getSQL() {
	if (name == "PRODUCTOS") {
		sql= "SELECT idproducto, caucho.idcaucho as idcaucho, cantidad, precio, alto, ancho, rin, caucho.tipo as tipo, marca.nombre as nombre FROM caucho, producto, marca WHERE producto.idcaucho = caucho.idcaucho and marca.idmarca = producto.idmarca and caucho.borrado =false and producto.borrado = false and marca.borrado= false AND nombre like '%"+tDato.getText()+"%' order by precio ASC";}
	else if (name == "VEHÍCULOS") { 
		sql= "SELECT marca, modelo, anno, vehiculo.idvehiculo as idvehiculo FROM vehiculomarca, vehiculo, vehiculomodelo WHERE vehiculomodelo.idmodelove = vehiculo.idmodelo and vehiculomodelo.idmarcave = vehiculomarca.idmarcave and vehiculomarca.borrado =false and vehiculomodelo.borrado= false and vehiculo.borrado=false AND marca like '%"+tDato.getText()+"%' order by vehiculo.anno ASC";
	}
	else if (name == "autos/cauchos") { 
		sql= "SELECT marca, modelo, anno, alto, ancho, rin, tipo, caucho.idcaucho FROM vehiculomarca, vehiculo, vehiculomodelo, caucho WHERE vehiculomodelo.idmodelove = vehiculo.idmodelo and vehiculomodelo.idmarcave = vehiculomarca.idmarcave and caucho.idcaucho = vehiculo.idcaucho and vehiculomarca.borrado =false and vehiculomodelo.borrado= false and vehiculo.borrado=false and caucho.borrado =false AND modelo like '%"+tDato.getText()+"%' order by modelo ASC";
	}
	return sql;
}

@Override
public void setConsulta(ResultSet rs) {
	// TODO Auto-generated method stub
	this.rs=rs;
}

public void limpiarTabla() {
	int filas=tabla.getRowCount();
	for(int i=0; i<filas;i++)
		model.removeRow(0);
}

public void desplegar() {
	// TODO Auto-generated method stub
	if (name =="PRODUCTOS") {
		Validacion.validarLetras(tDato);
		lElegido.setText("Buscar por marca: ");
		model.addColumn("COD");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Medidas");
		model.addColumn("Tipo");
		model.addColumn("Marca");
		}
	
	else if (name =="VEHÍCULOS") {
		Validacion.validarLetras(tDato);
		lElegido.setText("Buscar por marca: ");
		model.addColumn("COD");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Año");
	}
	}
	
/*	else if (name =="autos/cauchos") {
		Validacion.validarLetras(tDato);
		lElegido.setText("Buscar por modelo: ");
		model.addColumn("marca");
		model.addColumn("modelo");
		model.addColumn("medidas");
		model.addColumn("año");
		model.addColumn("tipo");}
}*/

@Override
public void mostrar() {
	
this.limpiarTabla ();
	
	Object[] fila;
	
	
	if (name =="PRODUCTOS") {
		try {
			if (rs.first())
	try {
		rs.beforeFirst();
		while(rs.next()) {
Object lindo = rs.getObject("ancho") + s + rs.getObject("alto") + s + rs.getObject("rin");
			
			fila= new Object[6];
			
			fila[0]= rs.getObject("idproducto");
			fila[1]= rs.getObject("cantidad");
			fila[2]= rs.getObject("precio");
			fila[3]= lindo;
			fila[4]= rs.getObject("tipo");
			fila[5]= rs.getObject("nombre");
			model.addRow(fila);
		}}catch (SQLException e) {
			// añadir longitud de tablas y todo eso, si total estoy en esto.
			e.printStackTrace();
		}
		
		else JOptionPane.showMessageDialog (null, "No se encontraron resultados para su busqueda");	
	
	}  catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}} //cerro el if como es debido

/*else if (name =="AUTOS/CAUCHOS") {
		try {
			if (rs.first()){
	try {
		rs.beforeFirst();
		while(rs.next()) {
			Object lindo = rs.getObject("ancho") + s + rs.getObject("alto") + s + rs.getObject("rin");
			fila= new Object[5];
			fila[0]= rs.getObject("marca");
			fila[1]= rs.getObject("modelo");
			fila[2]= rs.getObject("anno");
			fila[3]= lindo;
			fila[4]= rs.getObject("tipo");
			model.addRow(fila);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
else JOptionPane.showMessageDialog (null, "No se encontraron resultados para su busqueda");	
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}}*/
	
	else if (name =="VEHÍCULOS") {
		try {
			if (rs.first()){
	try {
		rs.beforeFirst();
		while(rs.next()) {
				fila= new Object[4];
				fila[0]= rs.getObject("idvehiculo");
				fila[1]= rs.getObject("marca");
				fila[2]= rs.getObject("modelo");
				fila[3]= rs.getObject("anno");
				model.addRow(fila);
		}}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
					
	 else JOptionPane.showMessageDialog (null, "No se encontraron resultados para su búsqueda.");	
	} catch (SQLException e) {
e.printStackTrace();
}} //cerro el if como es debido
}}
