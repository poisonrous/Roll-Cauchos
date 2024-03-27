package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import modelo.Caucho;
import modelo.Marca;
import modelo.OperarProducto;
import modelo.Producto;
import vista.IProducto;

public class CProducto implements ActionListener {
	
	private IProducto vista;
	private Producto producto;
	private OperarProducto oproducto;
	private Marca marca;
	private Caucho caucho;

	public CProducto(IProducto vista, Producto producto, OperarProducto oproducto, Marca marca, Caucho caucho) {
		this.vista=vista;
		this.producto=producto;
		this.oproducto=oproducto;
		this.marca=marca;
		this.caucho=caucho;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(vista.BUSCAR)) {
			if(vista.validarCodigo()) {
			Producto pro = oproducto.buscar(vista.getId());
			vista.buscar(pro.getMarca(), pro.getCaucho(), pro.getPrecio(),pro.getCantidad());
			} else JOptionPane.showMessageDialog(null, "Debe ingresar un código.");
		}
		
		if(e.getActionCommand().equals(vista.NUEVO)) {
			vista.agregar();
			DefaultComboBoxModel dcbmMA= new DefaultComboBoxModel<>(marca.vectorMarca());
			ComboBoxModel cbmarca=dcbmMA;	
			vista.cargarMarca(cbmarca);
			DefaultComboBoxModel dcbmCA= new DefaultComboBoxModel<>(caucho.vectorCaucho());
			ComboBoxModel cbcaucho=dcbmCA;	
			vista.cargarCaucho(cbcaucho);
			
		}
		
		if(e.getActionCommand().equals(vista.GUARDAR)) {
			if(vista.validarCampos()) {
			Marca mar = (Marca) vista.getMarca();
			Caucho cau = (Caucho) vista.getCaucho();
			OperarProducto opro = new OperarProducto();
			vista.setCodigo(opro.agregar(mar.getId(), cau.getId(), vista.getPrecio(), vista.getCantidad()));
			} else JOptionPane.showMessageDialog(null, "Debe completar la información.");
		}
		
		if(e.getActionCommand().equals(vista.REGRESAR)) {
			vista.limpiar();
		}
	}

}
