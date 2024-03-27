package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controlador.CVehiculoCaucho;
import modelo.OperarMVC;

public class VVehiculoCaucho extends JInternalFrame implements IVehiculoCaucho {

	 private JButton  bBuscar, bLimpiar, bGuardar, bRegresar;
	 private JPanel pPrincipal, pBotones, pMod;
	 private JComboBox cMarca, cModelo, cAnno, cCaucho;
	 private JTextField tMarca, tModelo, tAnno;
	 private JLabel lTitulo, lResultado;
	 private CVehiculoCaucho controlador;

	public VVehiculoCaucho() {
		super("Vehículo-Caucho");
		setSize(550,230);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setClosable(true);
		this.setIconifiable(true);
		
		lTitulo = new JLabel("BUSCADOR DE CAUCHO PARA AUTO");
		lTitulo.setFont(new Font("Arial", Font.BOLD,20));
		lTitulo.setHorizontalAlignment(JLabel.CENTER);
		this.add(lTitulo, BorderLayout.NORTH);
		
		pPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints reglas = new GridBagConstraints();
		
		reglas.weightx=1.0;
		reglas.weighty=1.0;
		reglas.gridx=0;
		reglas.gridy=0;
	    reglas.anchor =  GridBagConstraints.SOUTH;
		pPrincipal.add(new JLabel("Marca"), reglas);
		reglas.gridx=1;
		pPrincipal.add(new JLabel("Modelo"), reglas);
		reglas.gridx=2;
		pPrincipal.add(new JLabel("Año"), reglas);
		
	    reglas.anchor =  GridBagConstraints.NORTH;
		cMarca = new JComboBox();
		cMarca.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub		
				marcaSeleccion(e);
			}
		});
		
		Dimension dimcombo = new Dimension(150, 30);
		cMarca.setPreferredSize(dimcombo);
		reglas.gridx=0;
		reglas.gridy=1;
		pPrincipal.add(cMarca, reglas);
		cModelo = new JComboBox();
		cModelo.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub		
				modeloSeleccion(e);
			}
		});
		cModelo.setPreferredSize(dimcombo);
		reglas.gridx=1;
		pPrincipal.add(cModelo, reglas);
		cAnno = new JComboBox();
		reglas.gridx=2;
		cAnno.setPreferredSize(dimcombo);
		pPrincipal.add(cAnno, reglas);
		
		tMarca = new JTextField(12);
		tMarca.setPreferredSize(dimcombo);
		Validacion.validarLetras(tMarca);
		tMarca.setEditable(false);
		tMarca.setVisible(false);
		reglas.gridx=0;
		reglas.gridy=1;
		pPrincipal.add(tMarca, reglas);
		tModelo = new JTextField(12);
		tModelo.setPreferredSize(dimcombo);
		Validacion.validarLetras(tModelo);
		tModelo.setEditable(false);
		tModelo.setVisible(false);
		reglas.gridx=1;
		pPrincipal.add(tModelo, reglas);
		tAnno = new JTextField(12);
		tAnno.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tAnno);
		tAnno.setEditable(false);
		tAnno.setVisible(false);
		reglas.gridx=2;
		pPrincipal.add(tAnno, reglas);
		
		reglas.gridy=0;
		reglas.gridx=3;
		reglas.gridheight=2;
	    reglas.anchor =  GridBagConstraints.CENTER;
		bBuscar = new JButton("Buscar");
		bBuscar.setActionCommand(IVehiculoCaucho.BUSCAR);
		pPrincipal.add(bBuscar, reglas);
		bGuardar = new JButton("Guardar");
		bGuardar.setActionCommand(IVehiculoCaucho.GUARDAR);
		bGuardar.setVisible(false);
		pPrincipal.add(bGuardar, reglas);
		
		lResultado = new JLabel("");
		lResultado.setFont(new Font("Arial", Font.ITALIC, 15));
		lResultado.setHorizontalAlignment(JLabel.CENTER);
		reglas.gridy=2;
		reglas.gridx=0;
		reglas.gridwidth=4;
		pPrincipal.add(lResultado, reglas);
		pMod = new JPanel();
		pMod.add(new JLabel("Se recomienda utilizar cauchos de medida "));
		cCaucho = new JComboBox();
		pMod.add(cCaucho);
		pMod.setVisible(false);
		pPrincipal.add(pMod, reglas);
		this.add(pPrincipal);
		
		pBotones = new JPanel();
		bLimpiar = new JButton("Limpiar");
		bLimpiar.setActionCommand(IVehiculoCaucho.LIMPIAR);
		bRegresar = new JButton("Regresar");
		bRegresar.setActionCommand(IVehiculoCaucho.LIMPIAR);
		pBotones.add(bLimpiar);
		pBotones.add(bRegresar);
		bRegresar.setVisible(false);
		this.add(pBotones, BorderLayout.SOUTH);
	}
	@Override
	public void setControlador(CVehiculoCaucho c) {
		// TODO Auto-generated method stub
		controlador = c;
		cMarca.addActionListener(c);
		cModelo.addActionListener(c);
		cAnno.addActionListener(c);
		bBuscar.addActionListener(c);
		bLimpiar.addActionListener(c);
		bGuardar.addActionListener(c);
		bRegresar.addActionListener(c);
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

	@Override
	public void desplegar() {
		// TODO Auto-generated method stub
		controlador.actionPerformed(new ActionEvent(this, 1, IVehiculoCaucho.MARCA));
	}

	@Override
	public void cargarMarca(ComboBoxModel cbmarca) {
		// TODO Auto-generated method stub
		cMarca.setModel(cbmarca);
	}

	@Override
	public void cargarModelo(ComboBoxModel cbmodelo) {
		// TODO Auto-generated method stub
		cModelo.setModel(cbmodelo);
	}

	@Override
	public void cargarAnno(ComboBoxModel cbanno) {
		// TODO Auto-generated method stub
		cAnno.setModel(cbanno);
	}

	public void cargarCaucho(ComboBoxModel cbcaucho) {
		// TODO Auto-generated method stub
		cCaucho.setModel(cbcaucho);
		
	}
	@Override
	public Object getMarca() {
		// TODO Auto-generated method stub
		return cMarca.getSelectedItem();
	}

	@Override
	public Object getModelo() {
		// TODO Auto-generated method stub
		return cModelo.getSelectedItem();
	}

	@Override
	public Object getAnno() {
		// TODO Auto-generated method stub
		return cAnno.getSelectedItem();
	}

	@Override
	public void marcaSeleccion(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED)
			controlador.actionPerformed(new ActionEvent(this, 2, IVehiculoCaucho.MODELO));
	}

	@Override
	public void modeloSeleccion(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED)
			controlador.actionPerformed(new ActionEvent(this, 3, IVehiculoCaucho.ANNO));
	}

	@Override
	public Object getCaucho() {
		return cCaucho.getSelectedItem();
	}
	
	public boolean validarSeleccion(){
		return((cAnno.getSelectedIndex()>0)&&(cMarca.getSelectedIndex()>0)&&(cModelo.getSelectedIndex()>0));	
	}
	
	@Override
	public void buscar(String alto, String ancho, String rin, String tipo) {
		// TODO Auto-generated method stub
		tMarca.setText(cMarca.getSelectedItem().toString());
		tModelo.setText(cModelo.getSelectedItem().toString());
		tAnno.setText(cAnno.getSelectedItem().toString());
		cMarca.setVisible(false);
		tMarca.setVisible(true);
		cModelo.setVisible(false);
		tModelo.setVisible(true);
		cAnno.setVisible(false);
		tAnno.setVisible(true);
		
		lResultado.setText("Se recomienda utilizar caucho de medidas "+ancho+"/"+alto+"/"+rin+" de tipo "+tipo);
		lResultado.setVisible(true);
		System.out.println("Buscar");
	}
	
	@Override
	public void editar() {
		// TODO Auto-generated method stub
		lTitulo.setText("REGISTRO DE CAUCHO SUGERIDO");
		tMarca.setText(cMarca.getSelectedItem().toString());
		tModelo.setText(cModelo.getSelectedItem().toString());
		tAnno.setText(cAnno.getSelectedItem().toString());
		cMarca.setVisible(false);
		tMarca.setVisible(true);
		cModelo.setVisible(false);
		tModelo.setVisible(true);
		cAnno.setVisible(false);
		tAnno.setVisible(true);
		lResultado.setVisible(false);
		pMod.setVisible(true);
		bLimpiar.setVisible(false);
		bRegresar.setVisible(true);
		bBuscar.setVisible(false);
		bGuardar.setVisible(true);
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		lTitulo.setText("BUSCADOR DE CAUCHO PARA AUTO");
		tMarca.setVisible(false);
		cMarca.setVisible(true);
		cMarca.setSelectedIndex(0);
		tModelo.setVisible(false);
		cModelo.setVisible(true);
		cModelo.setSelectedIndex(-1);
		tAnno.setVisible(false);
		cAnno.setVisible(true);
		cAnno.setSelectedIndex(-1);
		lResultado.setVisible(false);
		pMod.setVisible(false);
		bGuardar.setVisible(false);
		bBuscar.setVisible(true);
		bRegresar.setVisible(false);
		bLimpiar.setVisible(true);
	}
}
