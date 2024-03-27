package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.MTaBase;

import vista.ITest;

public class CTest implements ActionListener {
	private MTaBase modelo;
	private ITest vista;
	
	public  CTest (MTaBase modelo, ITest vista) {
		// TODO Auto-generated constructor stub
		this.modelo=modelo;
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(vista.CONSULTA)) {
			vista.setConsulta(modelo.getResultSet(vista.getSQL()));
			vista.mostrar();
		}

	}
}
