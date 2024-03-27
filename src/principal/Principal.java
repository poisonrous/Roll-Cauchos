package principal;

import controlador.CTaBase;
import controlador.CTest;
import controlador.CVehiculo;
import modelo.MTaBase;
import modelo.MVehiculo;
import vista.ITaBase;
import vista.VTaBase;
import vista.ITest;
import vista.IVehiculo;
import vista.VTest;
import vista.VVehiculo;
import controlador.CControlador;
import controlador.CControladorMarca;
import controlador.CProducto;
import controlador.CVehiculoCaucho;
import modelo.Anno;
import modelo.Caucho;
import modelo.MConsulta;
import modelo.MCrudVehiculo;
import modelo.Marca;
import modelo.Marcas;
import modelo.Modelo;
import modelo.OConsulta;
import modelo.OMarcaConsulta;
import modelo.OperarMVC;
import modelo.OperarProducto;
import modelo.Producto;
import vista.IConsulta;
import vista.IConsultaMarca;
import vista.IProducto;
import vista.IVehiculoCaucho;
import vista.Padre;
import vista.VCaucho;
import vista.VMarca;
import vista.VProducto;
import vista.VVehiculoCaucho;

public class Principal {
	public static void main(String[] args) {
		
		try {
	         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	             if ("Windows".equals(info.getName())) {
	                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                 break;
	             }
	         }
	     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
	         e.printStackTrace();}
		
		IConsultaMarca vista2 = new VMarca();
		IConsulta vista = new VCaucho();
		OConsulta modelod = new OConsulta();
		MConsulta modeloe = new MConsulta();
		OMarcaConsulta modelof = new OMarcaConsulta();
		CControlador controlador = new CControlador(modeloe, modelod, vista);
		CControladorMarca controlador2 = new CControladorMarca(modeloe, modelof, vista2);
		vista.setControlador(controlador);
		vista2.setControladorMarca(controlador2);
		
		MCrudVehiculo vehiculo = new MCrudVehiculo();
		Marcas marca= new Marcas();
		Modelo modelo = new Modelo();
		IVehiculo vista3= new VVehiculo();
		CVehiculo controlador3= new CVehiculo(vista3, marca, modelo, vehiculo);
		vista3.setControlador(controlador3);
		
		IVehiculoCaucho vista4= new VVehiculoCaucho();
		Anno anno = new Anno();
		Caucho caucho = new Caucho();
		OperarMVC OMVC = new OperarMVC();
		CVehiculoCaucho controlador4= new CVehiculoCaucho(vista4, marca, modelo, anno, caucho, OMVC);
		
		IProducto vista5= new VProducto();
		Producto producto = new Producto();
		OperarProducto oproducto =  new OperarProducto();
		Marca mar = new Marca();
		CProducto controlador5 = new CProducto(vista5, producto, oproducto, mar, caucho);
		
		ITaBase vT1= new VTaBase("ALMACEN");
		MTaBase mT= new MTaBase();
		CTaBase cT1=new CTaBase(mT, vT1);
		vT1.setControlador(cT1);	
		vT1.desplegar();	
		
		ITaBase vT2= new VTaBase("PRODUCTOS");
		CTaBase cT2=new CTaBase(mT, vT2);
		vT2.setControlador(cT2);	
		vT2.desplegar();
		
		ITaBase vT3= new VTaBase("VEHÍCULOS");
		CTaBase cT3=new CTaBase(mT, vT3);
		vT3.setControlador(cT3);	
		vT3.desplegar();	
		
		
		ITaBase vT4= new VTaBase("MARCAS");
		CTaBase cT4=new CTaBase(mT, vT4);
		vT4.setControlador(cT4);	
		vT4.desplegar();
		
		ITaBase vT5= new VTaBase("AUTOS/CAUCHOS");
		CTaBase cT5=new CTaBase(mT, vT5);
		vT5.setControlador(cT5);	
		vT5.desplegar();
		
		ITest vT6= new VTest("PRODUCTOS");
		ITest vT7= new VTest("VEHÍCULOS");
		CTest cT6=new CTest(mT, vT6);
		vT6.setControlador(cT6);	
		CTest cT7=new CTest(mT, vT7);
		vT7.setControlador(cT7);	
		vT6.desplegar();
		vT7.desplegar();
		
		
		vista4.setControlador(controlador4);
		vista4.desplegar();
		
		vista5.setControlador(controlador5);
		
		Padre mdi = new Padre(vista, vista2, vista3, vista4, vista5, vT1, vT2, vT3, vT4, vT5, vT6, vT7);
		mdi.setVisible(true);
	}
}