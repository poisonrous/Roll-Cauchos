package vista;

import java.sql.ResultSet;

import controlador.CTest;

public interface ITest {
static final String CONSULTA="consulta";
	
	public void arrancar();
	public void setControlador(CTest controlador);
	public String getSQL();
	public void setConsulta(ResultSet rs);
	public void mostrar();
	public void desplegar();
	
}
