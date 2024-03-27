package modelo;

public class Producto {

	int id, cantidad;
	String marca, caucho;
	double precio;
	boolean borrado;
	
	public Producto(int id, int cantidad, String marca, String caucho, double precio, boolean borrado){
		this.id=id;
		this.cantidad=cantidad;
		this.marca=marca;
		this.caucho=caucho;
		this.precio=precio;
		this.borrado=borrado;
	}
	
	public Producto(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCaucho() {
		return caucho;
	}

	public void setCaucho(String caucho) {
		this.caucho = caucho;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	
	
}
