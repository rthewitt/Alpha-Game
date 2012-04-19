
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class NestedPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Vector<Star> Stars = new Vector<Star>();
	private int Width, Height;
	private Border border = new LineBorder(Color.GREEN, 1);
	
	NestedPanel(int w, int h)
	{
		Width = w;
		Height = h;
		setBounds(0, 0, Width, Height);
		setOpaque(false);
		setBackground(Color.BLACK);
		setBorder(border);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.fillRect(3, 3, Width - 3, Height - 3);
		
		for (int i = 0; i < Stars.size(); i++) 
    	{
        	Stars.elementAt(i).draw(g2d);
     	}
	}
}