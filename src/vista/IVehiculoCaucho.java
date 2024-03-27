package vista;

import java.awt.event.ItemEvent;
import javax.swing.ComboBoxModel;
import controlador.CVehiculoCaucho;
import modelo.OperarMVC;

public interface IVehiculoCaucho {
	public static String BUSCAR = "buscar";
	public static String LIMPIAR = "limpiar";
	public static String GUARDAR = "guardar";
	public static String MARCA = "marca";
	public static String MODELO = "modelo";
	public static String ANNO = "anno";
	
	public void setControlador(CVehiculoCaucho c);
	public void arrancar();
	public void desplegar();
	public void cargarMarca(ComboBoxModel cbmarca);
	public void cargarModelo(ComboBoxModel cbmodelo);
	public void cargarAnno(ComboBoxModel cbanno);
	public void cargarCaucho(ComboBoxModel cbcaucho);
	public Object getMarca();
	public Object getModelo();
	public Object getAnno();
	public void marcaSeleccion(ItemEvent e);
	public void modeloSeleccion(ItemEvent e);
	public Object getCaucho();
	public boolean validarSeleccion();
	public void buscar(String alto, String ancho, String rin, String tipo);
	public void editar();
	public void limpiar();
}
