package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BdConex {
	
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/roll";
	final String USUARIO = "root";
	final String CLAVE = "767254632";

	public BdConex() {
		con = null;
		try {
			// SE hace la conexio ODBC
			Class.forName(DRIVER).newInstance();

			// Se abre una conexion de nombre con
			con = DriverManager.getConnection(URL, USUARIO, CLAVE);

			if (con != null)
				System.out.println("Conexion exitosa a la BD!");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectar con el Driver");
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Se obtiene la conexion de la Base de Datos
	public Connection getConexion() {
		return con;
	}
	
	// Abre una conexion a la Base de Datos
	public void abrirConexion() {
        try {
            con = DriverManager.getConnection(URL, USUARIO, CLAVE);
            if (con != null)
				System.out.println("Conexion exitosa a la BD!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

	// Se desconecta de la Base de Datos
	public void desconectar() {
		con = null;
		if (con == null)
			System.out.println("BD Desconectada");
	}

	// Ejecuta sentencias SQL Update e Insert
	public int ejecutar(String sentencia) {
		int a = 0;
		try {
			ps = con.prepareStatement(sentencia);
			a = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return a;
	}

	// Ejecuta la sentencia SQL Select
	public ResultSet consultar(String sentencia) {
		try {
			ps = con.prepareStatement(sentencia);
			rs = ps.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

}

