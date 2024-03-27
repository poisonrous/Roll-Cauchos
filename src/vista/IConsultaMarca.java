package vista;

import controlador.CControladorMarca;

public interface IConsultaMarca {
	final String CONS = "CONSULTAR";
	final String ELIM = "ELIMINAR";
	final String MOD = "MODIFICAR";
	final String LIM = "LIMPIAR";
	final String CREA= "CREAR";
	
	public String getTabla();
	public int getCodigo();
	public String getC1();
	public String getC2();
	public String getC3();
	public String getC4();
	public void editar();
	public void noEditar();
	public void vaciar();
	public void arrancar();
	public void escribir(String C1, String C2, String C3, String C4);
	public void setCodigo(String cod);
	public void setControladorMarca(CControladorMarca cm);
}
