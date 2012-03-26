import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class UpgradeMenu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Control control;
	private Star star;
	private Resource res;
	private int Width = 0, Height = 0; 
	private Stats stat;
	private LandF LF = new LandF();
	private GridLayout layout = new GridLayout(0,1);
	
	private JTabbedPane Bar = new JTabbedPane();
	JButton done = new JButton("Next Level");
	JButton dual = new JButton("DUAL LASERS");
	JButton damage = new JButton("+1 DAMAGE");
	JButton laser = new JButton("LASER SIGHT");
	JButton machgun = new JButton("MACHINE GUN");
	JButton life = new JButton("LIFE UP");
	JButton speed = new JButton("SPEED UP");
	JButton hull = new JButton("HULL UP");
	JButton shipUp = new JButton("UPGRADE SHIP");
	
	UpgradeMenu(int x, int y, Control con, Stats s)
	{
		stat = s;
		control = con;
		Width = x - 8;
		Height = y - 31;
		setVisible(true);
		
		setBackground(Color.BLACK);
		
		star = new Star(Width, Height, this);
		star.setNumber(50);
		star.start();
		// Reference the class, should not be an object
//		res = stat.getResource();
		
		LF.TabbedPane(Bar);
		
		this.setLayout(null);
		
		setupButtons();
		
		NestedPanel np1 = new NestedPanel(Width, Height * 40);
		np1.setLayout(layout);
		np1.add(dual);
		np1.add(life);
		np1.add(speed);
		np1.add(hull);
		np1.add(shipUp);
		JScrollPane scroll = new JScrollPane(np1);
		LF.Scroll(scroll);
		Bar.addTab("SHIP", scroll);
		
		NestedPanel np2 = new NestedPanel(Width, Height);
		np2.setLayout(layout);
		np2.add(machgun);
		np2.add(damage);
		JScrollPane scroll2 = new JScrollPane(np2);
		Bar.addTab("WEAPONS", scroll2);
		
		NestedPanel np3 = new NestedPanel(Width, Height);
		np3.setLayout(layout);
		np3.add(laser);
		JScrollPane scroll3 = new JScrollPane(np3);
		Bar.addTab("SPECIAL", scroll3);
		
		JLabel label = new JLabel();
		// NOOOOOOOOOOOOO!!!!!!! 
		//label.setIcon(res.getCurrentShip());
		label.setBounds(0, 0, 70, 70);
		
		add(label);
		add(Bar);
		add(done);
		
		setBounds(0, 0, Width, Height);
		Bar.setBounds(0, Height/2, 495, 200);
		done.setBounds(0, Height - 30, Width, Height);
		done.setSize(Width, 30);
	}

	public void setupButtons()
	{
		LF.Button(done);
		
		dual.setPreferredSize(new Dimension(Width - 20, 50));
		dual.setMinimumSize(dual.getPreferredSize());
		LF.Button(dual);
		
		damage.setPreferredSize(new Dimension(Width - 20, 50));
		damage.setMinimumSize(damage.getPreferredSize());
		LF.Button(damage);
		
		laser.setPreferredSize(new Dimension(Width - 20, 50));
		laser.setMinimumSize(laser.getPreferredSize());
		LF.Button(laser);
		
		machgun.setPreferredSize(new Dimension(Width - 20, 50));
		machgun.setMinimumSize(machgun.getPreferredSize());
		LF.Button(machgun);
		
		life.setPreferredSize(new Dimension(Width - 20, 50));
		life.setMinimumSize(life.getPreferredSize());
		LF.Button(life);
		
		speed.setPreferredSize(new Dimension(Width - 20, 50));
		speed.setMinimumSize(speed.getPreferredSize());
		LF.Button(speed);
		
		hull.setPreferredSize(new Dimension(Width - 20, 50));
		hull.setMinimumSize(hull.getPreferredSize());
		LF.Button(hull);
		if(stat.getHull())
		{
			hull.setEnabled(false);
			hull.setBackground(Color.BLACK);
		}
		
		shipUp.setPreferredSize(new Dimension(Width - 20, 50));
		shipUp.setMinimumSize(shipUp.getPreferredSize());
		LF.Button(shipUp);
		
		done.addActionListener(this);
		dual.addActionListener(this);
		damage.addActionListener(this);
		machgun.addActionListener(this);
		life.addActionListener(this);
		laser.addActionListener(this);
		speed.addActionListener(this);
		hull.addActionListener(this);
		shipUp.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if("Next Level".equalsIgnoreCase(ae.getActionCommand())){
			
			star = null; done.setVisible(false);
			done = null;
			control.RunGame(3);
			
		} else if("Dual Lasers".equalsIgnoreCase(ae.getActionCommand()))
			stat.Dual();
			
		else if("DAMAGE UPGRADE".equalsIgnoreCase(ae.getActionCommand()))
			stat.DamageUp(5);
			
		else if("ALSER SIGHT".equalsIgnoreCase(ae.getActionCommand()))
			stat.addLaser();
			
		else if("MACHINE GUN".equalsIgnoreCase(ae.getActionCommand()))
			stat.addMachGun();
			
		else if("LIFE UP".equalsIgnoreCase(ae.getActionCommand()))
			stat.LifeUp(2);
			
		else if("SPEED UP".equalsIgnoreCase(ae.getActionCommand()))
			stat.IncrementSpeed();		
		
		else if("HULL UP".equalsIgnoreCase(ae.getActionCommand())) {
			stat.HullUp();
			hull.setEnabled(false);
			hull.setBackground(Color.BLACK);
		
		} else if("UPGRADE SHIP".equalsIgnoreCase(ae.getActionCommand()))
			stat.UpgradeShip();
	}
	
	public void	paintComponent(Graphics g)  
	{
		super.paintComponent(g);
		Graphics2D g2d	= (Graphics2D)	g;
		
		try
		{
        	star.draw(g2d);
		}
		catch(NullPointerException e)
		{
		}
	}
}