package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperarProducto {
	BdConex bd= new BdConex();
	ResultSet rs=null;
	public Producto buscar(int idproducto) {
		bd.abrirConexion();
		Producto producto = new Producto();
		rs=bd.consultar("SELECT nombre, alto, ancho, rin, tipo, precio, cantidad FROM marca, caucho, producto WHERE idproducto='"+idproducto+"' AND marca.idmarca=producto.idmarca AND caucho.idcaucho=producto.idcaucho");
		
	try {
		if(rs.first()) {
			rs.beforeFirst();
			rs.next();
			producto.setMarca(rs.getString("nombre"));
			producto.setCaucho(rs.getString("ancho")+"/"+rs.getString("alto")+"/"+rs.getString("rin")+"-"+rs.getString("tipo"));
			producto.setPrecio(Double.valueOf(rs.getString("precio")));
			producto.setCantidad(Integer.valueOf(rs.getString("cantidad")));
		}
		else {
			JOptionPane.showMessageDialog(null, "El registro no existe.");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return producto;
	}
	
	public String agregar(int idmarca, int idcaucho, double precio, int cantidad) {
		int op=0;
		String cod="";
		bd.abrirConexion();
		op=bd.ejecutar("INSERT INTO `producto`(`idmarca`, `idcaucho`, `precio`, `cantidad`) VALUES ('"+idmarca+"',"+idcaucho+",'"+precio+"',"+cantidad+")");
		if(op>0) {
			rs=bd.consultar("SELECT * FROM producto WHERE idmarca='"+idmarca+"' AND idcaucho='"+idcaucho+"' AND precio='"+precio+"' AND cantidad='"+cantidad+"'");
			try {
				rs.beforeFirst();
				rs.next();
				cod=rs.getString("idproducto");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Se ha registrado el producto bajo el código "+cod);}
		else
			{JOptionPane.showMessageDialog(null, "Error al registrar el producto");}
		bd.desconectar();
		return cod;
	}
}
