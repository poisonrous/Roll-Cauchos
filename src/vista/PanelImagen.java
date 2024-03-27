package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{
	private String url;
	private ImageIcon imagen;
	
	public PanelImagen(String url) {
		this.url=url;
	}
	
	public void paint(Graphics g) {
		Dimension tama=this.getSize();
		imagen=new ImageIcon(getClass().getResource(url));
		g.drawImage(imagen.getImage(), 0, 0, tama.width, tama.height, null);
		this.setOpaque(false);
		super.paintChildren(g);
		
	}

}
