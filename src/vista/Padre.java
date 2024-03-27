package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import vista.VTaBase;
import vista.VTest;


public class Padre extends JFrame {
	private Image re, re2, re3, re4, re5, re6, re7, re8, re9, re10;
	private JDesktopPane fondo;
	private VCaucho modulo;
	private VMarca modulo2;
	private VVehiculo modulo3;
	private VVehiculoCaucho modulo4;
	private VProducto modulo5;
	private VTaBase reporte1, reporte2, reporte3, reporte4, reporte5;
	private VTest reporte6, reporte7;
	private boolean bandera = true, bandera2 = true, bandera3 =true, bandera4 = true, bandera5 = true, bandera6 = true, bandera7 = true, bandera8 = true, bandera9 = true, bandera10 = true, bandera11 = true, bandera12 = true;
	
	public Padre(IConsulta modulo, IConsultaMarca modulo2, IVehiculo modulo3, IVehiculoCaucho modulo4, IProducto modulo5, ITaBase reporte1, ITaBase reporte2, ITaBase reporte3, ITaBase reporte4, ITaBase reporte5, ITest reporte6, ITest reporte7) {
		super("Roll C.A");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// dandole el tamaño adecuado a los iconos
		try {
			Image img = ImageIO.read(getClass().getResource("/caucho.png"));
			Image img2 = ImageIO.read(getClass().getResource("/tophat.png"));
			Image img3 = ImageIO.read(getClass().getResource("/autocaucho.png"));
			Image img4 = ImageIO.read(getClass().getResource("/dolar.png"));
			Image img5 = ImageIO.read(getClass().getResource("/Reporte.png"));
			Image img6 = ImageIO.read(getClass().getResource("/repair.jpg"));
			Image img7 = ImageIO.read(getClass().getResource("/autorepair.png"));
			Image img8 = ImageIO.read(getClass().getResource("/mechanicus.jpg"));
			Image img9 = ImageIO.read(getClass().getResource("/auto.jpg"));
			re = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			re2 =  img2.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			re3 =  img3.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			re4 =  img4.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			re5 =  img5.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			re6 =  img6.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			re7 =  img7.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			re8 =  img8.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH );
			re9 =  img8.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH );
			re10 =  img9.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH );
			
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon report = new ImageIcon (re5); 
		ImageIcon heroes = new ImageIcon (re8);
		
		Action m = new AccionMenu("Cauchos", KeyEvent.VK_1,
				"1","Abre el modulo ", new ImageIcon(re));
		Action m2 = new AccionMenu("Marcas", KeyEvent.VK_2,
				"2","Abre el modulo ", new ImageIcon(re2));
		Action m3 = new AccionMenu("Vehículos", KeyEvent.VK_3,
				"3","Abre el modulo ", new ImageIcon(re10));
		Action m4 = new AccionMenu("Vehículo-Caucho", KeyEvent.VK_4,
				"4","Abre el modulo ", new ImageIcon(re3));
		Action m5 = new AccionMenu("Productos", KeyEvent.VK_5,
				"5","Abre el modulo ", new ImageIcon(re4));
		
		Action r1 = new AccionMenu("Productos-Stock", KeyEvent.VK_A,
				"6", "Abrir herramienta de reportes / ",report);
		Action r2 = new AccionMenu("Productos-Lista", KeyEvent.VK_B,
				"7", "Abrir herramienta de reportes / ",report);
		Action r3 = new AccionMenu("Vehículos-Todos", KeyEvent.VK_C,
				"8", "Abrir herramienta de reportes / ",report);
		Action r4 = new AccionMenu("Marcas-Todos", KeyEvent.VK_D,
				"9", "Abrir herramienta de reportes / ", report);
		Action r5 = new AccionMenu("Cauchos por auto", KeyEvent.VK_E,
				"10", "Abrir herramienta de reportes / ", report);
		Action r6 = new AccionMenu("Buscador de productos", KeyEvent.VK_F,
				"11", "Abrir herramienta de reportes / ", new ImageIcon(re6));
		Action r7 = new AccionMenu("Buscador de vehículos", KeyEvent.VK_G,
				"12", "Abrir herramienta de reportes / ", new ImageIcon(re7));
		
		Action info1 = new AccionMenu("Grupo 1", KeyEvent.VK_A,
				"a", "Vea a los integrantes del ", heroes);
		Action info2 = new AccionMenu("Grupo 2", KeyEvent.VK_B,
				"b", "Vea a los integrantes del ",heroes);
	
		this.modulo = (VCaucho) modulo;
		this.modulo2 = (VMarca) modulo2;
		this.modulo3 = (VVehiculo) modulo3;
		this.modulo4 = (VVehiculoCaucho) modulo4;
		this.modulo5 = (VProducto) modulo5;
		this.reporte1=(VTaBase) reporte1;
		this.reporte2=(VTaBase) reporte2;
		this.reporte3=(VTaBase) reporte3;
		this.reporte4=(VTaBase) reporte4;
		this.reporte5=(VTaBase) reporte5;
		this.reporte6=(VTest) reporte6;
		this.reporte7=(VTest) reporte7;
		
		
		fondo = new JDesktopPane();
		fondo.setOpaque(false);
		PanelImagen pi = new PanelImagen("/fondo.jpg");
		pi.setLayout(new BorderLayout());
		this.add(pi, BorderLayout.CENTER);
		pi.add(fondo, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);

		JMenu mModulos = new JMenu("Módulos");
		mModulos.add(m);
		mModulos.add(m2);
		mModulos.add(m3);
		mModulos.add(m4);
		mModulos.add(m5);
		barra.add(mModulos);
		JMenu mReportes = new JMenu("Reportes");
		mReportes.add(r1);
		mReportes.add(r2);
		mReportes.add(r3);
		mReportes.add(r4);
		mReportes.add(r5);
		mReportes.add(r6);
		mReportes.add(r7);
		barra.add(mReportes);
		JMenu mInformacion = new JMenu("Acerca de...");
		mInformacion.add(info1);
		mInformacion.add(info2);
		barra.add(mInformacion);

	}

	private class AccionMenu extends AbstractAction {

		public AccionMenu(String nombre, int tecla, String valor, String hover, Icon icono) {
			this.putValue(NAME, nombre);
			this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(tecla, InputEvent.CTRL_DOWN_MASK));
			this.putValue(SHORT_DESCRIPTION, hover + nombre);
			this.putValue(MNEMONIC_KEY, tecla);
			this.putValue("Valor", valor);
			this.putValue(SMALL_ICON, icono);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (this.getValue("Valor").equals("1")) {
				if (bandera) {

					fondo.add(modulo);
					modulo.toFront();
					modulo.show();
					bandera = false;
				} else {
					modulo.toFront();
					modulo.show();
				}
				
			}	
			
			if (this.getValue("Valor").equals("2")) {
				if (bandera2) {

					fondo.add(modulo2);
					modulo2.toFront();
					modulo2.show();
					bandera2 = false;
				} else {
					modulo2.toFront();
					modulo2.show();
				}
				
			}
			
			if (this.getValue("Valor").equals("3")) {
				if (bandera3) {

					fondo.add(modulo3);
					modulo3.toFront();
					modulo3.show();
					bandera3 = false;
				} else {
					modulo3.toFront();
					modulo3.show();
				}
				
			}	
			if (this.getValue("Valor").equals("4")) {
				if (bandera4) {

					fondo.add(modulo4);
					modulo4.toFront();
					modulo4.show();
					bandera4 = false;
				} else {
					modulo4.toFront();
					modulo4.show();
				}
				
			}	
			
			if (this.getValue("Valor").equals("5")) {
				if (bandera5) {

					fondo.add(modulo5);
					modulo5.toFront();
					modulo5.show();
					bandera5 = false;
				} else {
					modulo5.toFront();
					modulo5.show();
				}
				
			}
			
			if (this.getValue("Valor").equals("6")) {
				if (bandera6) {

					fondo.add(reporte1);
					reporte1.toFront();
					reporte1.show();
					bandera6 = false;
				} else {
					reporte1.toFront();
					reporte1.show();
				}
				
			}
			
			if (this.getValue("Valor").equals("7")) {
				if (bandera7) {

					fondo.add(reporte2);
					reporte2.toFront();
					reporte2.show();
					bandera7 = false;
				} else {
					reporte2.toFront();
					reporte2.show();
				}
				
			}
			
			if (this.getValue("Valor").equals("8")) {
				if (bandera8) {

					fondo.add(reporte3);
					reporte3.toFront();
					reporte3.show();
					bandera8 = false;
				} else {
					reporte3.toFront();
					reporte3.show();
				}
			}
			if (this.getValue("Valor").equals("9")) {
					if (bandera9) {

						fondo.add(reporte4);
						reporte4.toFront();
						reporte4.show();
						bandera9 = false;
					} else {
						reporte4.toFront();
						reporte4.show();
					}
					
				}
				
				if (this.getValue("Valor").equals("10")) {
					if (bandera10) {

						fondo.add(reporte5);
						reporte5.toFront();
						reporte5.show();
						bandera10 = false;
					} else {
						reporte5.toFront();
						reporte5.show();
					}
					
				}
				
				if (this.getValue("Valor").equals("11")) {
					if (bandera11) {

						fondo.add(reporte6);
						reporte6.toFront();
						reporte6.show();
						bandera11 = false;
					} else {
						reporte6.toFront();
						reporte6.show();
					}
				}
					
					if (this.getValue("Valor").equals("12")) {
						if (bandera12) {

							fondo.add(reporte7);
							reporte7.toFront();
							reporte7.show();
							bandera12 = false;
						} else {
							reporte7.toFront();
							reporte7.show();
						}
						
					}
					if (this.getValue("Valor").equals("a")) {
						JOptionPane.showMessageDialog(fondo, "Rosalinda Abreu, V-28.231.061 \nJared Oropez, V-28.021.616 (retirado) \n Pedro Silva, V-28.256.628 (retirado)", "Grupo 3", JOptionPane.NO_OPTION, new ImageIcon (re9));/*(fondo, "Rosalinda Abreu, V-28.231.061 \nJared Oropez, V-28.021.616 (retirado) \n Pedro Silva, V-28.256.628 (retirado)", "Grupo 1");*/
					}
						
						if (this.getValue("Valor").equals("b")) {
						JOptionPane.showMessageDialog(fondo, "Neri Carballo, V-28.047.596 \n Jesús Perez, V-28.480.869  \n Andres Guedez, V-29.805.976", "Grupo 2", JOptionPane.NO_OPTION, new ImageIcon (re9));
							
						}
					
					
					
					
				}
			}
		
		}