package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Anno;
import modelo.MVehiculo;
import modelo.Marcas;
import modelo.Modelo;
import modelo.MCrudVehiculo;
import vista.IVehiculo;
import vista.VVehiculo;

public class CVehiculo implements ActionListener {
	
	private IVehiculo vista;
	private Marcas marca;
	private Modelo modelo;
	private MCrudVehiculo ovehiculo;

	public CVehiculo(IVehiculo vista, Marcas marca, Modelo modelo, MCrudVehiculo ovehiculo) {
		this.vista=vista;
		this.marca=marca;
		this.modelo=modelo;
		this.ovehiculo=ovehiculo;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals(IVehiculo.MODIFICAR)) {
			if(vista.getCodigo().length()==0) {
				JOptionPane.showMessageDialog(null, "Antes debe buscar un vehículo.");
			} else {
			if(vista.getMarcat().length()==0 || vista.getModelot().length()==0 || vista.getAnno().length()==0 ) {
					JOptionPane.showMessageDialog(null, "Uno o más de los campos estan vacios.");}
			else {
			DefaultComboBoxModel dcbmMA= new DefaultComboBoxModel<>(marca.vectorMarcasVe());
			ComboBoxModel cbmarca=dcbmMA;
			vista.cargarMarca(cbmarca);
			vista.modificar();
			}}
		}
		
		if(e.getActionCommand().equals(vista.MODELO)) {
			Marcas mar = (Marcas) vista.getMarca();
			DefaultComboBoxModel dcbmMO= new DefaultComboBoxModel<>(modelo.vectorModeloVe(mar.getId()));
			ComboBoxModel cbmodelo=dcbmMO;	
			vista.cargarModelo(cbmodelo);
		}
		
		if(e.getActionCommand().equals(vista.NUEVO)) {
			DefaultComboBoxModel dcbmMA= new DefaultComboBoxModel<>(marca.vectorMarcasVe());
			ComboBoxModel cbmarca=dcbmMA;	
			vista.cargarMarca(cbmarca);
			vista.nuevo();
		}
		
		if(e.getActionCommand().equals(vista.BUSCAR)) {
			if(vista.getCodigo().length()==0) {
				JOptionPane.showMessageDialog(null, "Debe ingresar el código de la consulta.");
			} else{
			MVehiculo v =	ovehiculo.buscar(vista.getCodigo());
			vista.escribir(v.getMarca(), v.getModelo(), v.getAnno());
			}
		}
		
		if(e.getActionCommand().equals(vista.GUARDAR)) {
			Marcas ma = (Marcas) vista.getMarca();
			Modelo mo = (Modelo) vista.getModelo();
			MCrudVehiculo m = new MCrudVehiculo();
			vista.setCodigo(m.crear(ma.getId(), mo.getId(), vista.getAnno(), vista.getMarcat(), vista.getModelot(), vista.getCaso()));
		}
		
		if(e.getActionCommand().equals(vista.ELIMINAR)) {
			MVehiculo consu= new MVehiculo();
			consu.setCodigo(vista.getCodigo());
			if(vista.getCodigo().length()==0) {
				JOptionPane.showMessageDialog(null, "Debe buscar un vehículo a eliminar.");
			}else {
			if(JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el vehículo?", "Eliminar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			ovehiculo.borrar(consu);
			vista.vaciar();
			}
			}
		}
		
		if(e.getActionCommand().equals(vista.GUARDARMOD)) {
			Marcas ma = (Marcas) vista.getMarca();
			Modelo mo = (Modelo) vista.getModelo();
			MCrudVehiculo m = new MCrudVehiculo();
			m.modificar(vista.getCodigo(), ma.getId(), mo.getId(), vista.getAnno(), vista.getMarcat(), vista.getModelot(), vista.getCaso());
		}
		
		if(e.getActionCommand().equals(vista.LIMPIAR)) {vista.vaciar();}
	}}

