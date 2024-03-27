package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MTaBase {
	public ResultSet getResultSet(String sql) {
		BdConex bd= new BdConex();
		ResultSet rs= bd.consultar(sql);
		return rs;}

	
	/*public ResultSet getReporte(String sql) {
		return null;}
	
	public String getNombreT(int selección) {
		return null;}*/
}
