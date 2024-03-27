package modelo;

public class MVehiculo {
	private String codigo, marca, modelo, anno;
	private boolean borrado;

	public MVehiculo() {}
	public MVehiculo (String codigo, String marca, String modelo, String anno, boolean borrado) {
		this.codigo=codigo;
		this.marca=marca;
		this.modelo=modelo;
		this.anno=anno;
		this.setBorrado(borrado);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	
	
}
