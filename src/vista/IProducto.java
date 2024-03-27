package vista;

import javax.swing.ComboBoxModel;

import controlador.CProducto;

public interface IProducto {
	public static String BUSCAR ="buscar";
	public static String NUEVO ="nuevo";
	public static String GUARDAR ="guardar";
	public static String REGRESAR ="regresar";
	
	
	public void setControlador(CProducto c);
	public void arrancar();
	public int getId();
	public void cargarMarca(ComboBoxModel cbmarca);
	public void cargarCaucho(ComboBoxModel cbmodelo);
	public Object getMarca();
	public Object getCaucho();
	public double getPrecio();
	public int getCantidad();
	public boolean validarCodigo();
	public boolean validarCampos();
	public void buscar(String marca, String caucho, double precio, int cantidad);
	public void agregar();
	public void setCodigo(String cod);
	public void limpiar();

}
