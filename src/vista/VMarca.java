package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.CControladorMarca;

public class VMarca extends JInternalFrame implements IConsultaMarca, ActionListener {
	
	private JTextField tMarca, tNombre, tRif, tContacto, tTelefono;
	private JButton btElim, btMod, btNuev, btLim, btCons, btModGuar, btNueGuar, btAtrasM, btAtrasN;
	private JPanel pPrincipal, pPrincipal2, pBotones, pMod, pNuevo, pTitulo, pTitulo2, pTitulo3;
	private JLabel lCodigo1, lCodigo2, titulo, titulo2, titulo3;
	
	
	public VMarca() {
		super("Marcas");
		this.setSize(450,350);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setClosable(true);
		this.setIconifiable(true);
		
		Dimension dimcombo = new Dimension(150, 30);
		//norte
		pPrincipal2=new JPanel();
		this.add(pPrincipal2, BorderLayout.NORTH);
		
		pTitulo= new JPanel();
		titulo= new JLabel("BUSCARDOR DE MARCAS", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		pTitulo.add(titulo);
		pPrincipal2.add(pTitulo);
		
		pPrincipal = new JPanel();
		this.add(pPrincipal, BorderLayout.SOUTH);
		
		
		//panel titulo2
		pTitulo2 =new JPanel();
		titulo2=new JLabel("ACTUALIZACION DE MARCAS", JLabel.CENTER);
		titulo2.setFont(new Font("Arial", Font.BOLD, 20));
		pTitulo2.add(titulo2);
		pTitulo2.setVisible(false);
		pPrincipal2.add(pTitulo2);
		
		
		//panel titulo2
		pTitulo3 =new JPanel();
		titulo3=new JLabel("REGISTRO DE MARCAS", JLabel.CENTER);
		titulo3.setFont(new Font("Arial", Font.BOLD, 20));
		pTitulo3.add(titulo3);
		pTitulo3.setVisible(false);
		pPrincipal2.add(pTitulo3);
		
		//sur
		pBotones = new JPanel();
		btElim = new JButton("Eliminar");
		btElim.setActionCommand(IConsulta.ELIM);
		pBotones.add(btElim);
		
		btMod = new JButton("Modificar");
	//	btMod.setActionCommand(IConsulta.MOD); eliminé el ActionCommand porque aquí todavía no se envía nada al controlador
		btMod.addActionListener(this);
		pBotones.add(btMod);
		
		btNuev = new JButton("Nuevo");
		btNuev.addActionListener(this);
	//	btNuev.setActionCommand(IConsulta.NUEV); otro ActionCommand que no es necesario porque nunca se usa
		pBotones.add(btNuev);
		
		btLim = new JButton("Limpiar");
		btLim.setActionCommand(IConsulta.LIM);
		pBotones.add(btLim);
		
		pPrincipal.add(pBotones);
		
		//panel modificar
		pMod = new JPanel();
		btModGuar = new JButton("Guardar");
		btModGuar.setActionCommand(IConsulta.MOD); //aquí estaban usando el mismo ActionCommand que para crear
		pMod.add(btModGuar);
		
		btAtrasM = new JButton("Regresar");
		btAtrasM.addActionListener(this);
		pMod.add(btAtrasM);
		pMod.setVisible(false);
		pPrincipal.add(pMod);
		
		//panel nuevo
		pNuevo = new JPanel();
		btNueGuar = new JButton("Guardar");
		btNueGuar.setActionCommand(IConsulta.GUAR);
		pNuevo.add(btNueGuar);
		
		btAtrasN = new JButton("Regresar");
		btAtrasN.addActionListener(this);
		pNuevo.add(btAtrasN);
		pNuevo.setVisible(false);
		pPrincipal.add(pNuevo);
		
		//centro
		JPanel pForm = new JPanel();
		pForm.setLayout(new GridLayout(5,3,5,5));
		
		JPanel pCons = new JPanel();
		lCodigo2 = new JLabel("  Codigo:  ");
		lCodigo2.setVisible(false);
		pCons.add(lCodigo2);
		lCodigo1 = new JLabel("                                 Codigo:");
		pCons.add(lCodigo1);
		tMarca = new JTextField(10);
		tMarca.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tMarca);
		btCons = new JButton("Consultar");
		btCons.setActionCommand(IConsulta.CONS);
		pCons.add(tMarca);
		pCons.add(btCons);
		pForm.add(pCons);
		
		JPanel pNom = new JPanel();
		pNom.add(new JLabel("   Nombre: "));
		tNombre = new JTextField(10);
		tNombre.setPreferredSize(dimcombo);
		Validacion.validarLetras(tNombre);
		tNombre.setEditable(false);
		pNom.add(tNombre);
		pForm.add(pNom);
		
		JPanel pRif = new JPanel();
		pRif.add(new JLabel(" Contacto: ")); 
		tRif = new JTextField(10);
		tRif.setPreferredSize(dimcombo);
		tRif.setEditable(false);
		pRif.add(tRif);
		pForm.add(pRif);
		
		JPanel pCont = new JPanel();
		pCont.add(new JLabel(" Telefono: "));
		tContacto = new JTextField(10);
		tContacto.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tContacto);
		tContacto.setEditable(false);
		pCont.add(tContacto);
		pForm.add(pCont);
		
		JPanel pTlf = new JPanel();
		pTlf.add(new JLabel("          RIF:")); 
		tTelefono = new JTextField(10);
		tTelefono.setPreferredSize(dimcombo);
		tTelefono.setEditable(false);
		pTlf.add(tTelefono);
		pForm.add(pTlf);
		
		this.add(pForm, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object boton=e.getSource();
		
		if(boton==btMod) {
			titulo.setVisible(false);
			pTitulo2.setVisible(true);
			btCons.setVisible(false);
			lCodigo1.setVisible(false);
			lCodigo2.setVisible(true);
			this.editar();
			pBotones.setVisible(false);
			pMod.setVisible(true);
		}
		if(boton==btAtrasM) {
			titulo.setVisible(true);
			pTitulo2.setVisible(false);
			btCons.setVisible(true);
			lCodigo1.setVisible(true);
			lCodigo2.setVisible(false);
			this.noEditar();
			pBotones.setVisible(true);
			pMod.setVisible(false);
			this.vaciar();
		}
		if(boton==btNuev) {
			titulo.setVisible(false);
			pTitulo3.setVisible(true);
			btCons.setVisible(false);
			lCodigo1.setVisible(false);
			lCodigo2.setVisible(true);
			this.editar();
			this.vaciar();
			pBotones.setVisible(false);
			pNuevo.setVisible(true);
		}
		if(boton==btAtrasN) {
			titulo.setVisible(true);
			pTitulo3.setVisible(true);
			btCons.setVisible(true);
			lCodigo1.setVisible(true);
			lCodigo2.setVisible(false);
			this.noEditar();
			this.vaciar();
			pBotones.setVisible(true);
			pNuevo.setVisible(false);
		}
	}

	public String getTabla() {
		return null;
	}

	public int getCodigo() {
		try{
			return Integer.parseInt(tMarca.getText());
		} 
		catch (Exception e){
		return 0;
		}
	}


	public void editar() {
		tMarca.setEditable(false);
		tNombre.setEditable(true);
		tRif.setEditable(true);
		tContacto.setEditable(true);
		tTelefono.setEditable(true);
	}

	
	public void noEditar() {
		tMarca.setEditable(true);
		tNombre.setEditable(false);
		tRif.setEditable(false);
		tContacto.setEditable(false);
		tTelefono.setEditable(false);
	}

	public void vaciar() {
		tMarca.setText("");
		tNombre.setText("");
		tRif.setText("");
		tContacto.setText("");
		tTelefono.setText("");
	}
	
	public void arrancar() {
	
		this.setVisible(true);
	}


	public String getC1() {
		// TODO Auto-generated method stub
		return tNombre.getText();
	}

	public String getC4() {
		// TODO Auto-generated method stub
		return tRif.getText();
	}

	public String getC2() {
		// TODO Auto-generated method stub
		return tContacto.getText();
	}

	public String getC3() {
		// TODO Auto-generated method stub
		return tTelefono.getText();
	}

	public void escribir( String C1, String C2, String C3, String C4) {
		// TODO Auto-generated method stub
		this.tNombre.setText(C1);
		this.tRif.setText(C2);
		this.tContacto.setText(C3);
		this.tTelefono.setText(C4);
		
	}
	
	public void setCodigo(String cod) {
		tMarca.setText(cod);
	}

	public void setControladorMarca(CControladorMarca cm) {
		// TODO Auto-generated method stub
		btElim.addActionListener(cm);
		btMod.addActionListener(cm);
		btNuev.addActionListener(cm);
		btLim.addActionListener(cm);
		btCons.addActionListener(cm);
		btModGuar.addActionListener(cm);
		btNueGuar.addActionListener(cm);
		btAtrasM.addActionListener(cm);
		btAtrasN.addActionListener(cm);
	}

}
