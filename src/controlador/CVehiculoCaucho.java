package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Anno;
import modelo.Caucho;
import modelo.Caucho;
import modelo.Marcas;
import modelo.Modelo;
import modelo.OperarMVC;
import vista.IVehiculoCaucho;

public class CVehiculoCaucho implements ActionListener {
	
	private IVehiculoCaucho vista;
	private Marcas marca;
	private Modelo modelo;
	private Anno anno;
	private OperarMVC omvc;
	private Caucho caucho;

	public CVehiculoCaucho(IVehiculoCaucho vista, Marcas marca, Modelo modelo, Anno anno, Caucho caucho, OperarMVC omvc) {
		this.vista=vista;
		this.marca=marca;
		this.modelo=modelo;
		this.anno=anno;
		this.caucho=caucho;
		this.omvc=omvc;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(vista.MARCA)) {
			DefaultComboBoxModel dcbmMA= new DefaultComboBoxModel<>(marca.vectorMarcas());
			ComboBoxModel cbmarca=dcbmMA;	
			vista.cargarMarca(cbmarca);
		}
		
		if(e.getActionCommand().equals(vista.MODELO)) {
			Marcas mar = (Marcas) vista.getMarca();
			DefaultComboBoxModel dcbmMO= new DefaultComboBoxModel<>(modelo.vectorModelo(mar.getId()));
			ComboBoxModel cbmodelo=dcbmMO;	
			vista.cargarModelo(cbmodelo);
		}
		
		if(e.getActionCommand().equals(vista.ANNO)) {
			Modelo mod = (Modelo) vista.getModelo();
			DefaultComboBoxModel dcbmAN= new DefaultComboBoxModel<>(anno.vectorAnno(mod.getId()));
			ComboBoxModel cbmanno=dcbmAN;	
			vista.cargarAnno(cbmanno);
		}
		if(e.getActionCommand().equals(IVehiculoCaucho.BUSCAR)) {
			Anno an = (Anno) vista.getAnno();
			if (vista.validarSeleccion()){
			if(!(an.getIdCaucho()==1)) {
			Caucho cau = omvc.buscar(an.getIdCaucho());
			vista.buscar(cau.getAlto(), cau.getAncho(), cau.getRin(), cau.getTipo());
			} else if (JOptionPane.showConfirmDialog(null, "Este vehículo no tiene caucho asignado. ¿Desea registrarlo?",
					"Caucho no encontrado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION) {
				DefaultComboBoxModel dcbmCA= new DefaultComboBoxModel<>(caucho.vectorCaucho());
				ComboBoxModel cbcaucho=dcbmCA;	
				vista.cargarCaucho(cbcaucho);
				vista.editar();}

			} else JOptionPane.showMessageDialog(null, "Debe completar la información");}
		
		if(e.getActionCommand().equals(IVehiculoCaucho.LIMPIAR)) {
			vista.limpiar();
		}
		
		if(e.getActionCommand().equals(IVehiculoCaucho.GUARDAR)) {
			Anno vehiculo = (Anno) vista.getAnno();
			Caucho caucho = (Caucho) vista.getCaucho();
			OperarMVC omvc = new OperarMVC();
			omvc.agregar(vehiculo.getId(), caucho.getId());
			vista.limpiar();
		}
	}

}
