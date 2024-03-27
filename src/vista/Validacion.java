package vista;


import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Validacion {
 
	
	public static void validarLetras (JTextField tx) {
		tx.addKeyListener(
		new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
		char car=e.getKeyChar();
		
		if (Character.isDigit(car)) {
			Toolkit.getDefaultToolkit().beep();
			e.consume();}
		}
		});
		
		}
		
		public static  void validarNumeros (JTextField tx) {
			tx.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			char car=e.getKeyChar();
			
			if (!Character.isDigit(car)) {
				Toolkit.getDefaultToolkit().beep();
				e.consume();
			}
			}
			});}
		
		public static void validarPrecio (JTextField tx) {
			tx.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
		/*		String precio = tx.getText();*/
				
				if ((!Character.isDigit(car))&&(!String.valueOf(car).equals("."))) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				
			/*if(precio.substring(precio.length()-1).equals(".")) {
					String[] p = precio.split(".");
					while(p[1].length()<2) {	
					}
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}*/
				}
				});
		}
			
		public static void validarLongitud (JTextField tx, int cantidad) {
				tx.addKeyListener(new KeyAdapter() {
				public void keyTyped (KeyEvent e) {
				int tamanno=tx.getText().length();
				
				if (tamanno>=cantidad) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				}
				});
	}
}
