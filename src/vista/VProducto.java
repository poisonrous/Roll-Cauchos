package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.CProducto;

public class VProducto extends JInternalFrame implements IProducto {
	
	private JButton bBuscar, bNuevo, bGuardar, bRegresar;
	private JPanel pPrincipal, pBoton;
	private JComboBox cMarca, cCaucho;
	private JTextField tCodigo, tMarca, tCaucho, tPrecio, tCantidad;
	private JLabel lTitulo;
	private CProducto controlador;

	public VProducto() {
		super("Vehículo-Caucho");
		setSize(450, 300);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setClosable(true);
		this.setIconifiable(true);
		
		Dimension dimcombo = new Dimension(150, 30);
		
		lTitulo = new JLabel("BUSCADOR DE PRODUCTOS");
		lTitulo.setFont(new Font("Arial", Font.BOLD,20));
		lTitulo.setHorizontalAlignment(JLabel.CENTER);
		this.add(lTitulo, BorderLayout.NORTH);
		
		pPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints reglas = new GridBagConstraints();
		
		reglas.weightx=1.0;
		reglas.weighty=1.0;
		reglas.gridx=0;
		reglas.gridy=0;
		reglas.anchor =  GridBagConstraints.EAST;
		pPrincipal.add(new JLabel("Código:"), reglas);
		reglas.gridy=1;
		pPrincipal.add(new JLabel("Marca:"), reglas);
		reglas.gridy=2;
		pPrincipal.add(new JLabel("Caucho:"), reglas);
		reglas.gridy=3;
		pPrincipal.add(new JLabel("Precio:"), reglas);
		reglas.gridy=4;
		pPrincipal.add(new JLabel("Disponibilidad:"), reglas);
		
		tCodigo = new JTextField(15);
		tCodigo.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tCodigo);
		reglas.gridx=1;
		reglas.gridy=0;
		pPrincipal.add(tCodigo, reglas);
		tMarca = new JTextField(15);
		tMarca.setPreferredSize(dimcombo);
		tMarca.setEditable(false);
		reglas.gridy=1;
		pPrincipal.add(tMarca, reglas);
		cMarca = new JComboBox();
		cMarca.setPreferredSize(dimcombo);
		cMarca.setVisible(false);
		pPrincipal.add(cMarca, reglas);
		tCaucho = new JTextField(15);
		tCaucho.setPreferredSize(dimcombo);
		tCaucho.setEditable(false);
		reglas.gridy=2;
		pPrincipal.add(tCaucho, reglas);
		cCaucho = new JComboBox();
		cCaucho.setPreferredSize(dimcombo);
		cCaucho.setVisible(false);
		pPrincipal.add(cCaucho, reglas);
		tPrecio = new JTextField(15);
		tPrecio.setPreferredSize(dimcombo);
		Validacion.validarPrecio(tPrecio);
		tPrecio.setEditable(false);
		reglas.gridy=3;
		pPrincipal.add(tPrecio, reglas);
		tCantidad = new JTextField(15);
		tCantidad.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tCantidad);
		tCantidad.setEditable(false);
		reglas.gridy=4;
		pPrincipal.add(tCantidad, reglas);
		bBuscar = new JButton("Consultar");
		bBuscar.setActionCommand(IProducto.BUSCAR);
		reglas.anchor =  GridBagConstraints.CENTER;
		reglas.gridx=3;
		reglas.gridy=0;
		pPrincipal.add(bBuscar, reglas);
		bGuardar = new JButton("Guardar");
		bGuardar.setActionCommand(IProducto.GUARDAR);
		bGuardar.setVisible(false);
		pPrincipal.add(bGuardar);
		this.add(pPrincipal);
		
		pBoton = new JPanel();
		bNuevo = new JButton("Nuevo");
		bNuevo.setActionCommand(IProducto.NUEVO);
		bRegresar = new JButton("Regresar");
		bRegresar.setActionCommand(IProducto.REGRESAR);
		bRegresar.setVisible(false);
		pBoton.add(bNuevo);
		pBoton.add(bRegresar);
		this.add(pBoton, BorderLayout.SOUTH);
	}
	@Override
	public void setControlador(CProducto c) {
		// TODO Auto-generated method stub
		controlador = c;
		bBuscar.addActionListener(c);
		bNuevo.addActionListener(c);
		bGuardar.addActionListener(c);
		bRegresar.addActionListener(c);
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
	
	public int getId() {
		return Integer.valueOf(tCodigo.getText());
	}

	@Override
	public void cargarMarca(ComboBoxModel cbmarca) {
		// TODO Auto-generated method stub
		cMarca.setModel(cbmarca);
	}

	@Override
	public void cargarCaucho(ComboBoxModel cbmodelo) {
		// TODO Auto-generated method stub
		cCaucho.setModel(cbmodelo);
	}

	@Override
	public Object getMarca() {
		// TODO Auto-generated method stub
		return cMarca.getSelectedItem();
	}

	@Override
	public Object getCaucho() {
		// TODO Auto-generated method stub
		return cCaucho.getSelectedItem();
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return Double.valueOf(tPrecio.getText());
	}

	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return Integer.valueOf(tCantidad.getText());
	}
	public boolean validarCodigo() {
		return (!(tCodigo.getText().length()==0));
	}

	@Override
	public boolean validarCampos() {
		// TODO Auto-generated method stub
		return ((cMarca.getSelectedIndex()>0)&&(cCaucho.getSelectedIndex()>0)&&(Double.valueOf(tPrecio.getText())>0)&&(Integer.valueOf(tCantidad.getText())>0));
	}

	@Override
	public void buscar(String marca, String caucho, double precio, int cantidad) {
		// TODO Auto-generated method stub
		tMarca.setText(marca);
		tCaucho.setText(caucho);
		tPrecio.setText(""+precio);
		tCantidad.setText(""+cantidad);
	}

	@Override
	public void agregar() {
		// TODO Auto-generated method stub
		tCodigo.setText("");
		tCodigo.setEditable(false);
		tMarca.setVisible(false);
		cMarca.setVisible(true);
		tCaucho.setVisible(false);
		cCaucho.setVisible(true);
		tPrecio.setText("");
		tPrecio.setEditable(true);
		tCantidad.setText("");
		tCantidad.setEditable(true);
		bBuscar.setVisible(false);
		bGuardar.setVisible(true);
		bNuevo.setVisible(false);
		bRegresar.setVisible(true);
	}
	
	public void setCodigo(String cod) {
		tCodigo.setText(cod);
		tMarca.setText(cMarca.getSelectedItem().toString());
		tMarca.setVisible(true);
		cMarca.setVisible(false);
		tCaucho.setText(cCaucho.getSelectedItem().toString());
		tCaucho.setVisible(true);
		cCaucho.setVisible(false);
		tPrecio.setEditable(false);
		tCantidad.setEditable(false);
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		tCodigo.setText("");
		tCodigo.setEditable(true);
		tMarca.setText("");
		tMarca.setVisible(true);
		cMarca.setVisible(false);
		tCaucho.setText("");
		tCaucho.setVisible(true);
		cCaucho.setVisible(false);
		tPrecio.setText("");
		tPrecio.setEditable(false);
		tCantidad.setText("");
		tCantidad.setEditable(false);
		bBuscar.setVisible(true);
		bGuardar.setVisible(false);
		bNuevo.setVisible(true);
		bRegresar.setVisible(false);
	}

}
