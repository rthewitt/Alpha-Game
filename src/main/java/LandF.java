
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LandF
{
	private Border border = new LineBorder(Color.GREEN, 1);
	
	LandF()
	{
	}
	
	public void Button(JButton jb)
	{
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setBorder(border);
		jb.setForeground(Color.GREEN);
		jb.setFont(new Font("sansserif",Font.PLAIN,20));
	}
	
	public void Panel(JPanel p)
	{
	}
	
	public void ToolBar(JToolBar tb)
	{
		tb.setOpaque(false);
		tb.setBorder(border);
		tb.setForeground(Color.GREEN);
		tb.setLayout(new GridLayout());
	}
	
	public void Scroll(JScrollPane sp)
	{
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.getVerticalScrollBar().setBackground(Color.BLACK);
		sp.getVerticalScrollBar().setForeground(Color.GREEN);
	}
	
	public void TabbedPane(JTabbedPane tp)
	{
		tp.setOpaque(false);
		tp.setBorder(border);
		tp.setBackground(Color.BLACK);
		tp.setForeground(Color.GREEN);
	}
}