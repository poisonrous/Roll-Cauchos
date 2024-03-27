package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.CVehiculo;

public class VVehiculo extends JInternalFrame implements IVehiculo, ActionListener{
	
	 private JButton  bBuscar, bLimpiar, bModificar, bGuardarMod, bGuardarNuevo, bNuevo, bEliminar, bRegresarM, bRegresarN;
	 private JPanel pPrincipal, pSur, pMod, pNuevo, pBotones;
	 private JComboBox cMarca, cModelo;
	 private JTextField tMarca, tModelo, tAnno, tCodigo;
	 private JLabel lTitulo;
	 private CVehiculo controlador;

	 public VVehiculo() {
			super("Vehículo");
			setSize(450, 300);
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.setClosable(true);
			this.setIconifiable(true);
			this.setResizable(false);
			
			lTitulo = new JLabel("BUSCADOR DE VEHÍCULOS");
			lTitulo.setFont(new Font("Arial", Font.BOLD,20));
			lTitulo.setHorizontalAlignment(JLabel.CENTER);
			this.add(lTitulo, BorderLayout.NORTH);
			
			pSur = new JPanel();
			this.add(pSur, BorderLayout.SOUTH);
			
			pPrincipal = new JPanel(new GridBagLayout());
			GridBagConstraints reglas = new GridBagConstraints();
			
			reglas.weightx=1.0;
			reglas.weighty=1.0;
			reglas.gridx=0;
			reglas.gridy=0;
			reglas.anchor = GridBagConstraints.EAST;
			pPrincipal.add(new JLabel("Código:"), reglas);
			reglas.gridy=1;			
			pPrincipal.add(new JLabel("Marca:"), reglas);
			reglas.gridy=2;
			pPrincipal.add(new JLabel("Modelo:"), reglas);
			reglas.gridy=3;
			pPrincipal.add(new JLabel("Año:"), reglas);
			
			Dimension dimcombo = new Dimension(150, 30);
			tCodigo = new JTextField(12);
			tCodigo.setPreferredSize(dimcombo);
			Validacion.validarNumeros(tCodigo);
			reglas.gridx=1;
			reglas.gridy=0;
			reglas.anchor = GridBagConstraints.CENTER;
			pPrincipal.add(tCodigo);
			
			reglas.gridy=1;
			tMarca = new JTextField(12);
			tMarca.setPreferredSize(dimcombo);
			tMarca.setEditable(false);
			cMarca = new JComboBox();
			cMarca.addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub		
					marcaSeleccion(e);
				}
			});
			cMarca.addActionListener(this);
			cMarca.setPreferredSize(dimcombo);
			cMarca.setVisible(false);
			pPrincipal.add(cMarca, reglas);
			pPrincipal.add(tMarca, reglas);
			tModelo = new JTextField(12);
			tModelo.setPreferredSize(dimcombo);
			tModelo.setEditable(false);
			reglas.gridy=2;
			pPrincipal.add(tModelo, reglas);
			cModelo = new JComboBox();
			cModelo.addActionListener(this);
			cModelo.setPreferredSize(dimcombo);
			cModelo.setVisible(false);
			pPrincipal.add(cModelo, reglas);
			
			tAnno = new JTextField(12);
			tAnno.setPreferredSize(dimcombo);
			tAnno.setEditable(false);
			Validacion.validarNumeros(tAnno);
			Validacion.validarLongitud(tAnno, 4);
			reglas.gridy=3;
			pPrincipal.add(tAnno, reglas);
			bBuscar = new JButton("Consultar");
			bBuscar.setActionCommand(IVehiculo.BUSCAR);
			reglas.anchor =  GridBagConstraints.CENTER;
			reglas.gridx=3;
			reglas.gridy=0;
			pPrincipal.add(bBuscar, reglas);
			this.add(pPrincipal, BorderLayout.CENTER);
			
			pBotones = new JPanel();
			bEliminar = new JButton("Eliminar");
			bEliminar.setActionCommand(IVehiculo.ELIMINAR);
			pBotones.add(bEliminar);
			bModificar = new JButton("Modificar");
			bModificar.setActionCommand(IVehiculo.MODIFICAR);
			pBotones.add(bModificar);
			bNuevo = new JButton("Nuevo");
			bNuevo.setActionCommand(IVehiculo.NUEVO);
			pBotones.add(bNuevo);
			bLimpiar = new JButton("Limpiar");
			bLimpiar.setActionCommand(IVehiculo.LIMPIAR);
			pBotones.add(bLimpiar);
			
			pMod = new JPanel();
			bGuardarMod = new JButton("Guardar");
			bGuardarMod.setActionCommand(IVehiculo.GUARDARMOD);
			pMod.add(bGuardarMod);
			bRegresarM = new JButton("Regresar");
			bRegresarM.setActionCommand(IVehiculo.LIMPIAR);
			pMod.add(bRegresarM);
			pMod.setVisible(false);
			
			pNuevo = new JPanel();
			bGuardarNuevo = new JButton("Guardar");
			bGuardarNuevo.setActionCommand(IVehiculo.GUARDAR);
			pNuevo.add(bGuardarNuevo);
			bRegresarN = new JButton("Regresar");
			bRegresarN.setActionCommand(IVehiculo.LIMPIAR);
			pNuevo.add(bRegresarN);
			pNuevo.setVisible(false);

			pSur.add(pBotones);
			pSur.add(pMod);
			pSur.add(pNuevo);
	 }

	@Override
	public void setControlador(CVehiculo c) {
		// TODO Auto-generated method stub
		controlador = c;
		cMarca.addActionListener(c);
		cModelo.addActionListener(c);
		bBuscar.addActionListener(c);
		bNuevo.addActionListener(c);
		bLimpiar.addActionListener(c);
		bModificar.addActionListener(c);
		bGuardarNuevo.addActionListener(c);
		bGuardarMod.addActionListener(c);
		bEliminar.addActionListener(c);
		bRegresarM.addActionListener(c);
		bRegresarN.addActionListener(c);
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		this.setVisible(true);
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
	public String getAnno() {
		// TODO Auto-generated method stub
		return tAnno.getText();
	}

	@Override
	public void marcaSeleccion(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED)
			controlador.actionPerformed(new ActionEvent(this, 2, IVehiculo.MODELO));
	}

	@Override
	public void escribir(String marca, String modelo, String anno) {
		// TODO Auto-generated method stub
		tMarca.setText(marca);
		tModelo.setText(modelo);
		tAnno.setText(anno);
	}

	@Override
	public void modificar() {
		int i=0, t=0;
			lTitulo.setText("ACTUALIZACIÓN DE VEHÍCULO");
			tCodigo.setEditable(false);
			pBotones.setVisible(false);
			pMod.setVisible(true);
			tMarca.setVisible(false);
			cMarca.setVisible(true);
			
		while (!String.valueOf(cMarca.getSelectedItem()).equals(tMarca.getText())) {
				cMarca.setSelectedIndex(i);
				i++;
			};
			tMarca.setText(String.valueOf(cMarca.getSelectedItem()));
			
			tModelo.setVisible(false);
			cModelo.setVisible(true);
			
		while (!String.valueOf(cModelo.getSelectedItem()).equals(tModelo.getText())) {
				cModelo.setSelectedIndex(t);
				t++;
			};	
			tModelo.setText(String.valueOf(cModelo.getSelectedItem()));
			
			tAnno.setEditable(true);
		}
	
	public void nuevo() {
		lTitulo.setText("REGISTROS DE VEHÍCULO");
		tCodigo.setEditable(false);
		pBotones.setVisible(false);
		pNuevo.setVisible(true);
		tMarca.setVisible(false);
		cMarca.setVisible(true);
		tModelo.setVisible(false);
		cModelo.setVisible(true);
		tAnno.setEditable(true);
		tAnno.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cMarca) {
			if(String.valueOf(cMarca.getSelectedItem())=="Otra") {
				tMarca.setVisible(true);
				tMarca.setEditable(true);
				cMarca.setVisible(false);
				tModelo.setVisible(true);
				tModelo.setEditable(true);
				cModelo.setVisible(false);
			}
			}
	
		if(e.getSource()==cModelo) {
			if(String.valueOf(cModelo.getSelectedItem())=="Otro") {
				tModelo.setVisible(true);
				tModelo.setEditable(true);
				cModelo.setVisible(false);
				}
		}
		
	/*	if(e.getSource()==bRegresarM||e.getSource()==bRegresarN||e.getSource()==bLimpiar) {
			tCodigo.setEditable(true);
			pBotones.setVisible(true);
			pMod.setVisible(false);
			pNuevo.setVisible(false);
			tMarca.setVisible(true);
			tMarca.setEditable(false);
			tMarca.setText("");
			cMarca.setVisible(false);
			tModelo.setVisible(true);
			tModelo.setEditable(false);
			tModelo.setText("");
			cModelo.setVisible(false);
			tAnno.setEditable(false);
			tAnno.setText("");
		}*/
}

	@Override
	public int getCaso() {
		// TODO Auto-generated method stub
		int caso=0;
		if(cMarca.isVisible()&&cModelo.isVisible()) caso=1;
		if(cMarca.isVisible()&&tModelo.isVisible()) caso=2;
		if(tMarca.isVisible()&&tModelo.isVisible()) caso=3;
		return caso;
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return tCodigo.getText();
	}

	@Override
	public String getMarcat() {
		// TODO Auto-generated method stub
		return tMarca.getText();
	}

	@Override
	public String getModelot() {
		// TODO Auto-generated method stub
		return tModelo.getText();
	}

	@Override
	public void vaciar()  {
		lTitulo.setText("BUSCADOR DE VEHÍCULOS");
		tCodigo.setEditable(true);
		tCodigo.setText("");
		pBotones.setVisible(true);
		pMod.setVisible(false);
		pNuevo.setVisible(false);
		tMarca.setVisible(true);
		tMarca.setEditable(false);
		tMarca.setText("");
		cMarca.setVisible(false);
		tModelo.setVisible(true);
		tModelo.setEditable(false);
		tModelo.setText("");
		cModelo.setVisible(false);
		tAnno.setEditable(false);
		tAnno.setText("");
	}

	@Override
	public void setCodigo(String cod) {
		// TODO Auto-generated method stub
		tCodigo.setText(cod);
	}}