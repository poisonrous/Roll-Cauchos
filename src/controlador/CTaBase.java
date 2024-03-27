package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BdConex;
import modelo.MTaBase;
import vista.ITaBase;


public class CTaBase implements ActionListener {

	private ITaBase vista;
	private MTaBase modelo; 

	public CTaBase(MTaBase modelo, ITaBase vista) {
		this.vista= vista;
		this.modelo=modelo;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(ITaBase.CONSULTA)) {
			vista.setConsulta(modelo.getResultSet(vista.getOrders()));
			
		}
		
	}

}
