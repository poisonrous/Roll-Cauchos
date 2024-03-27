package vista;
import java.awt.event.ItemEvent;
import javax.swing.ComboBoxModel;
import controlador.CVehiculo;

public interface IVehiculo {
	public static String BUSCAR = "buscar";
	public static String GUARDAR = "guardar";
	public static String MODELO = "modelo";
	public static String MODIFICAR = "modificar";
	public static String NUEVO="nuevo";
	public static String ELIMINAR="eliminar";
	public static String LIMPIAR="limpiar";
	public static String GUARDARMOD="guardarmod";
	
	public void setControlador(CVehiculo c);
	public void arrancar();
	public void cargarMarca(ComboBoxModel cbmarca);
	public void cargarModelo(ComboBoxModel cbmodelo);
	public Object getMarca();
	public Object getModelo();
	public String getAnno();
	public String getMarcat();
	public String getModelot();
	public void marcaSeleccion(ItemEvent e);
	public String getCodigo();
	public void escribir(String marca, String modelo, String anno);
	public void modificar();
	public void nuevo();
	public void setCodigo(String cod);
	public void vaciar();
	public int getCaso();
}