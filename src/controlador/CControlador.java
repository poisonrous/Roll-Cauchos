package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.IConsulta;
import modelo.MConsulta;
import modelo.OConsulta;


public class CControlador implements ActionListener{
	
	private OConsulta modelo;
	private MConsulta modeloc;
	private IConsulta vista;
	
	public CControlador( MConsulta modeloc, OConsulta modelo, IConsulta vista){
		this.modelo=modelo;
		this.modeloc=modeloc;
		this.vista=vista;
	}



	public void actionPerformed(ActionEvent e) {
		
		MConsulta consu= new MConsulta();
		boolean resultado;
		
		if(e.getActionCommand().equals(IConsulta.CONS)){
			
			consu = modelo.buscar(vista.getCodigo());
			if(consu!=null){
				vista.escribir((String.valueOf(consu.getC1())), String.valueOf(consu.getC2()), String.valueOf(consu.getC3()), String.valueOf(consu.getC4()));
				
			}}
			if (e.getActionCommand().equals(IConsulta.ELIM)){
				if(vista.getCodigo()!=0){
					consu.setCodigo(vista.getCodigo());
					resultado = modelo.borrar(consu);
					
					if(resultado){
						JOptionPane.showMessageDialog(null, "Datos eliminados de forma exitosa");
						vista.vaciar();
					} else {
						JOptionPane.showMessageDialog(null, "Error al eliminar");
						
					}
					
					
				}else 
					JOptionPane.showMessageDialog(null, "Debe realizar una busqueda primero");
				
			} 
			if (e.getActionCommand().equals(IConsulta.GUAR)){
				if(String.valueOf(vista.getCodigo()).equals("")){
					JOptionPane.showMessageDialog(null, "Debe de ingresar un codigo primero");
				} else {
					
					consu.setCodigo(vista.getCodigo());
					consu.setC1(vista.getC1());
					consu.setC2(vista.getC2());
					consu.setC3(vista.getC3());
					consu.setC4(vista.getC4());
					modelo.crear(consu);
					
				}
			} 
			if (e.getActionCommand().equals(IConsulta.MOD)){
				
				if(vista.getCodigo()!=0){
					
					consu.setCodigo(vista.getCodigo());
					consu.setC1(vista.getC1());
					consu.setC2(vista.getC2());
					consu.setC3(vista.getC3());
					consu.setC4(vista.getC4());
					
					resultado = modelo.modificar(consu);
					
					if(resultado){
						JOptionPane.showMessageDialog(null, "Datos guardados exitosamente");
					} else{
						JOptionPane.showMessageDialog(null, "Error al modificar datos");
						
					}
					
				} else{
					JOptionPane.showMessageDialog(null, "Debe realizar una busqueda primera");
				}
				
			} 
			if(e.getActionCommand().equals(IConsulta.LIM)){
				
				vista.vaciar(); //¿para qué crearon el método de vaciar si no lo estaban utilizando?
			}
			
		}
		
	}
	


