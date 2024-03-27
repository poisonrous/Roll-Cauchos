package modelo;

public class MConsulta {
	private String tabla;
	private int codigo;
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private boolean borrado;
	
	public boolean isBorrado(){
		return borrado;
	}
	public void setBorrado(boolean borrado){
		this.borrado = borrado;
	}
	public String getTabla(){
		return tabla;
	}
	public void setTabla(String tabla){
		this.tabla=  tabla;
	}
	public int getCodigo(){
		return codigo;
	}
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}
	
	
	public String getC1(){
		return c1;
	}
	public void setC1(String c1){
		this.c1=c1;
	}
	public String getC2(){
		return c2;
	}
	public void setC2(String c2){
		this.c2=c2;
	}
	public String getC3(){
		return c3;
	}
	public void setC3(String c3){
		this.c3=c3;
	}
	public String getC4(){
		return c4;
	}
	public void setC4(String c4){
		this.c4=c4;
	}
	
	
	
	
}
