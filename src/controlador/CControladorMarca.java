package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.IConsulta;
import vista.IConsultaMarca;
import modelo.MConsulta;
import modelo.OMarcaConsulta;

public class CControladorMarca implements ActionListener{
	
	private OMarcaConsulta modelo;
	private MConsulta modeloc;
	private IConsultaMarca vista;
	
	public CControladorMarca(MConsulta modeloc, OMarcaConsulta modelo, IConsultaMarca vista){
		this.modelo=modelo;
		this.modeloc=modeloc;
		this.vista=vista;
	}
		
	

	public void actionPerformed(ActionEvent e) {
		
		MConsulta consu2= new MConsulta();
		boolean resultado2;
		
		if(e.getActionCommand().equals(IConsultaMarca.CONS)){
			
			consu2 = modelo.buscar(vista.getCodigo());
			if(consu2!=null){
				
				vista.escribir((String.valueOf(consu2.getC1())), String.valueOf(consu2.getC2()), String.valueOf(consu2.getC3()), String.valueOf(consu2.getC4()));
				
			} }
			if (e.getActionCommand().equals(IConsulta.ELIM)){
				if(vista.getCodigo()!=0){
					consu2.setCodigo(vista.getCodigo());
					resultado2 = modelo.borrar(consu2);
					
					if(resultado2){
						JOptionPane.showMessageDialog(null, "Datos eliminados de forma exitosa");
						vista.vaciar();
					} else {
						JOptionPane.showMessageDialog(null, "Error al eliminar");
						
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Debe realizar una busqueda primero");
				}
			
			}
			
			if (e.getActionCommand().equals(IConsulta.GUAR)){
					
					consu2.setCodigo(vista.getCodigo());
					consu2.setC1(vista.getC1());
					consu2.setC2(vista.getC2());
					consu2.setC3(vista.getC3());
					consu2.setC4(vista.getC4());
					modelo.crear(consu2);
					
					
			}
			 
			if (e.getActionCommand().equals(IConsultaMarca.MOD)){
				
				if(vista.getCodigo()!=0){
					
					consu2.setCodigo(vista.getCodigo());
					consu2.setC1(vista.getC1());
					consu2.setC2(vista.getC2());
					consu2.setC3(vista.getC3());
					consu2.setC4(vista.getC4());
					
					resultado2 = modelo.modificar(consu2);
					
					if(resultado2){
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
	



