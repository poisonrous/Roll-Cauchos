package vista;

import java.sql.ResultSet;
import java.util.ArrayList;

import controlador.CTaBase;

public interface ITaBase {
	final String IMPRIMIR = "imprimir";
	final String CONSULTA = "consulta";
	
	
	public void setControlador(CTaBase c);
	public String getOrders ();
	public void setConsulta(ResultSet rs);
	public void desplegar();
	
	
	
	
	/* public void mostrar (ArrayList <String> NombreC, int Columnas);
public String getName ();*/
	


}
