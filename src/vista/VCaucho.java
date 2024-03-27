package vista;

import java.awt.BorderLayout;
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

import controlador.CControlador;
import controlador.CControladorMarca;

public class VCaucho extends JInternalFrame implements IConsulta, ActionListener{
	
	private JTextField tCaucho, tAncho, tAlto, tRin, tTipo;
	private JButton btElimM, btModM, btNuevM, btLimM, btConsM, btModGuarM, btNueGuarM, btAtrasMM, btAtrasNM;
	private JPanel pPrincipal, pPrincipal2, pBotones, pMod, pNuevo, pTitulo, pTitulo2, pTitulo3;
	private JLabel lCodigo1, lCodigo2, titulo, titulo2, titulo3;
	
	
	public VCaucho() {
		super("Cauchos");
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
		titulo= new JLabel("BUSCARDOR DE CAUCHOS", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		pTitulo.add(titulo);
		pPrincipal2.add(pTitulo);
		
		pPrincipal = new JPanel();
		this.add(pPrincipal, BorderLayout.SOUTH);
		
		
		//panel titulo2
		pTitulo2 =new JPanel();
		titulo2=new JLabel("ACTUALIZACION DE CAUCHOS", JLabel.CENTER);
		titulo2.setFont(new Font("Arial", Font.BOLD, 20));
		pTitulo2.add(titulo2);
		pTitulo2.setVisible(false);
		pPrincipal2.add(pTitulo2);
		
		
		//panel titulo2
		pTitulo3 =new JPanel();
		titulo3=new JLabel("REGISTRO DE CAUCHOS", JLabel.CENTER);
		titulo3.setFont(new Font("Arial", Font.BOLD, 20));
		pTitulo3.add(titulo3);
		pTitulo3.setVisible(false);
		pPrincipal2.add(pTitulo3);
		
		//sur
		pBotones = new JPanel();
		btElimM = new JButton("Eliminar");
		btElimM.setActionCommand(IConsulta.ELIM);
		pBotones.add(btElimM);
		
		btModM = new JButton("Modificar");
//		btMod.setActionCommand(IConsulta.MOD); eliminé el ActionCommand porque aquí todavía no se envía nada al controlador
		btModM.addActionListener(this);
		pBotones.add(btModM);
		
		btNuevM = new JButton("Nuevo");
		btNuevM.addActionListener(this);
//		btNuev.setActionCommand(IConsulta.NUEV); otro ActionCommand que no es necesario porque nunca se usa
		pBotones.add(btNuevM);
		
		btLimM = new JButton("Limpiar");
		btLimM.setActionCommand(IConsulta.LIM);
		pBotones.add(btLimM);
		
		pPrincipal.add(pBotones);
		
		//panel modificar
		pMod = new JPanel();
		btModGuarM = new JButton("Guardar");
		btModGuarM.setActionCommand(IConsulta.MOD); //aquí estaban usando el mismo ActionCommand que para crear
		pMod.add(btModGuarM);
		
		btAtrasMM = new JButton("Regresar");
		btAtrasMM.addActionListener(this);
		pMod.add(btAtrasMM);
		pMod.setVisible(false);
		pPrincipal.add(pMod);
		
		//panel nuevo
		pNuevo = new JPanel();
		btNueGuarM = new JButton("Guardar");
		btNueGuarM.setActionCommand(IConsulta.GUAR);
		pNuevo.add(btNueGuarM);
		
		btAtrasNM = new JButton("Regresar");
		btAtrasNM.addActionListener(this);
		pNuevo.add(btAtrasNM);
		pNuevo.setVisible(false);
		pPrincipal.add(pNuevo);
		
		//centro
		JPanel pForm = new JPanel();
		pForm.setLayout(new GridLayout(5,3,5,5));
		
		JPanel pCons = new JPanel();
		lCodigo2 = new JLabel("Codigo:  ");
		lCodigo2.setVisible(false);
		pCons.add(lCodigo2);
		lCodigo1 = new JLabel("                              Codigo:");
		pCons.add(lCodigo1);
		tCaucho = new JTextField(10);
		tCaucho.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tCaucho);
		btConsM = new JButton("Consultar");
		btConsM.setActionCommand(IConsulta.CONS);
		pCons.add(tCaucho);
		pCons.add(btConsM);
		pForm.add(pCons);
		
		
		JPanel pAnc = new JPanel();
		pAnc.add(new JLabel("  Ancho: "));
		tAncho = new JTextField(10);
		tAncho.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tAncho);
		Validacion.validarLongitud(tAncho, 3);
		tAncho.setEditable(false);
		pAnc.add(tAncho);
		pForm.add(pAnc);
		
		JPanel pAlt = new JPanel();
		pAlt.add(new JLabel("      Alto: "));
		tAlto = new JTextField(10);
		tAlto.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tAlto);
		Validacion.validarLongitud(tAlto, 2);
		tAlto.setEditable(false);
		pAlt.add(tAlto);
		pForm.add(pAlt);
		
		JPanel pRin = new JPanel();
		pRin.add(new JLabel("       Rin: "));
		tRin = new JTextField(10);
		tRin.setPreferredSize(dimcombo);
		Validacion.validarNumeros(tRin);
		Validacion.validarLongitud(tRin, 2);
		tRin.setEditable(false);
		pRin.add(tRin);
		pForm.add(pRin);
		
		JPanel pTip = new JPanel();
		pTip.add(new JLabel("     Tipo: "));
		tTipo = new JTextField(10);
		tTipo.setPreferredSize(dimcombo);
		tTipo.setEditable(false);
		pTip.add(tTipo);
		pForm.add(pTip);
		
		this.add(pForm, BorderLayout.CENTER);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
Object boton=e.getSource();
		
		if(boton==btModM) {
			titulo.setVisible(false);
			pTitulo2.setVisible(true);
			btConsM.setVisible(false);
			lCodigo1.setVisible(false);
			lCodigo2.setVisible(true);
			this.editar();
			pBotones.setVisible(false);
			pMod.setVisible(true);
		}
		if(boton==btAtrasMM) {
			titulo.setVisible(true);
			pTitulo2.setVisible(false);
			btConsM.setVisible(true);
			lCodigo1.setVisible(true);
			lCodigo2.setVisible(false);
			this.noEditar();
			pBotones.setVisible(true);
			pMod.setVisible(false);
			this.vaciar();
		}
		if(boton==btNuevM) {
			titulo.setVisible(false);
			pTitulo3.setVisible(true);
			btConsM.setVisible(false);
			lCodigo1.setVisible(false);
			lCodigo2.setVisible(true);
			this.editar();
			this.vaciar();
			pBotones.setVisible(false);
			pNuevo.setVisible(true);
		}
		if(boton==btAtrasNM) {
			titulo.setVisible(true);
			pTitulo3.setVisible(true);
			btConsM.setVisible(true);
			lCodigo1.setVisible(true);
			lCodigo2.setVisible(false);
			this.noEditar();
			this.vaciar();
			pBotones.setVisible(true);
			pNuevo.setVisible(false);
		}
	}

	public String getTabla() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getCodigo() {
		// TODO Auto-generated method stub
		try{
			return Integer.parseInt(tCaucho.getText());
		}
		catch(Exception e){
			return 0;}
	}

	public void editar() {
		// TODO Auto-generated method stub
		tCaucho.setEditable(false);
		tAncho.setEditable(true);
		tAlto.setEditable(true);
		tRin.setEditable(true);
		tTipo.setEditable(true);
	}

	public void noEditar() {
		// TODO Auto-generated method stub
		tCaucho.setEditable(true);
		tAncho.setEditable(false);
		tAlto.setEditable(false);
		tRin.setEditable(false);
		tTipo.setEditable(false);
	}

	public void vaciar() {
		// TODO Auto-generated method stub
		tCaucho.setText("");
		tAncho.setText("");
		tAlto.setText("");
		tRin.setText("");
		tTipo.setText("");
	}

	public void arrancar() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}


	public void setControlador(CControlador c) {
		// TODO Auto-generated method stub
		btElimM.addActionListener(c);
		btModM.addActionListener(c);
		btNuevM.addActionListener(c); 
		btLimM.addActionListener(c); 
		btConsM.addActionListener(c); 
		btModGuarM.addActionListener(c); 
		btNueGuarM.addActionListener(c); 
		btAtrasMM.addActionListener(c); 
		btAtrasNM.addActionListener(c);
	}


	public String getC1() {
		// TODO Auto-generated method stub
		return tAncho.getText();
	}


	public String getC2() {
		// TODO Auto-generated method stub
		return tAlto.getText();
	}


	public String getC3() {
		// TODO Auto-generated method stub
		return tRin.getText();
	}


	public String getC4() {
		// TODO Auto-generated method stub
		return tTipo.getText();
	}


	public void escribir( String C1, String C2, String C3,
			String C4) {
		// TODO Auto-generated method stub
		
		this.tAncho.setText(C1);
		this.tAlto.setText(C2);
		this.tRin.setText(C3);
		this.tTipo.setText(C4);
	}

	public void setCodigo(String cod) {
		tCaucho.setText(cod);
	}


}
