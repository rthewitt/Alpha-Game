import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;


public class GameState
{
	private int Level;
	private int ship = 0;
	private int Speed;
	private int Enemies;
	private int Life;
	private int Damage;
	private boolean MachGun;
	private boolean Laser;
	private boolean HullUp;
	private boolean Dual;
	
	private Control con;
	private Game game;
	private Resource res;
	private Collision col;
	
	
	GameState()
	{
		
	}
	
	public void init()
	{
		Level = 1;
		Damage = 5;
		Life = 20;
		Speed = 5;
		MachGun = false;
		Laser = false;
		HullUp = false;
		Dual = false;
	}
	
	public void updateShip()
	{
		BufferedImage img = null;
		if(getHull())
		{
			switch(getShip())
			{
				case 1: img = Resource.smallGreenArmor; break;
				
				case 2: img = Resource.medGreenArmor; break;
				
				case 3: img = Resource.largeGreenArmor; break;
				
				case 4: img = Resource.smallRedArmor; break;
				
				case 5: img = Resource.medRedArmor; break;
				
				case 6: img = Resource.largeRedArmor; break;
				
				case 7: img = Resource.smallBlueArmor; break;
				
				case 8: img = Resource.medBlueArmor; break;
				
				case 9: img = Resource.largeBlueArmor; break;
			}
		}
		else
		{
			switch(getShip())
			{
				case 1: img = Resource.smallGreen;
					Resource.hullShip = new ImageIcon(Resource.smallGreenArmor);
					Resource.nextShip = new ImageIcon(Resource.medGreen); break;
				
				case 2: img = Resource.medGreen;
					Resource.hullShip = new ImageIcon(Resource.medGreenArmor);
					Resource.nextShip = new ImageIcon(Resource.largeGreen); break;
				
				case 3: img = Resource.largeGreen;
					Resource.hullShip = new ImageIcon(Resource.largeGreenArmor); break;
					
				case 4: img = Resource.smallRed;
					Resource.hullShip = new ImageIcon(Resource.smallRedArmor);
					Resource.nextShip = new ImageIcon(Resource.medRed); break;
				
				case 5: img = Resource.medRed;
					Resource.hullShip = new ImageIcon(Resource.medRedArmor);
					Resource.nextShip = new ImageIcon(Resource.largeRed); break;
				
				case 6: img = Resource.largeRed;
					Resource.hullShip = new ImageIcon(Resource.largeRedArmor); break;
				
				case 7: img = Resource.smallBlue;
					Resource.hullShip = new ImageIcon(Resource.smallBlueArmor);
					Resource.nextShip = new ImageIcon(Resource.medBlue); break;
				
				case 8: img = Resource.medBlue;
					Resource.hullShip = new ImageIcon(Resource.medBlueArmor);
					Resource.nextShip = new ImageIcon(Resource.largeBlue); break;
				
				case 9: img = Resource.largeBlue;
					Resource.hullShip = new ImageIcon(Resource.largeBlueArmor); break;
			}
		}
		
		Resource.currentShip = Toolkit.getDefaultToolkit().createImage(img.getSource());
	}
	
	public void addMe(Game g)
	{
		game = g;
	}
	
	public Game getGame()
	{
		if(game == null)
			System.out.println(game);
			
		return game;
	}
	
	public void addMe(Control c)
	{
		con = c;
	}
	
	public void addMe(Resource r)
	{
		res = r;
	}
	
	public void addMe(Collision c)
	{
		col = c;
	}
	
	public Collision getCollision()
	{
		return col;
	}
	
	public Resource getResource()
	{
		return res;
	}
	
	public int getLevel()
	{
		return Level;
	}
	
	public void setLevel(int lvl)
	{
		Level = lvl;
	}
	
	public void LevelUp()
	{
		Level++;
	}
	
	public int getShip()
	{
		return ship;
	}
	
	public void UpgradeShip()
	{
		ship++;
	}
	
	public void setShip(int s)
	{
		ship = s;
	}
	
	public int getEnemies()
	{
		return Enemies;
	}
	
	public void IncrementEnemies()
	{
		Enemies ++;
	}
	
	public void setEnemies(int e)
	{
		Enemies = e;
	}
	
	public void DecrementEnemies()
	{
		Enemies --;
		LevelOver();
	}
	
	private void LevelOver()
	{
		if(Enemies <= 0)
		{
			LevelUp();
			con.RunUpgrade(2);
		}
	}
	
	public void Dual()
	{
		Dual = true;
	}
	
	public boolean getDual()
	{
		return Dual;
	}
	
	public void DamageUp(int up)
	{
		Damage += up;
	}
	
	public int getDamage()
	{
		return Damage;
	}
	
	public void addLaser()
	{
		Laser = true;
	}
	
	public boolean getLaser()
	{
		return Laser;
	}
	
	public void addMachGun()
	{
		MachGun = true;
	}
	
	public boolean getMachGun()
	{
		return MachGun;
	}
	
	public void IncrementSpeed()
	{
		Speed += 3;
	}
	
	public int getSpeed()
	{
		return Speed;
	}
	
	public void LifeUp(int up)
	{
		Life += up;
	}
	
	public int getLife()
	{
		return Life;
	}
	
	public void HullUp()
	{
		HullUp = true;
	}
	
	public void HullDown()
	{
		HullUp = false;
	}
	
	public boolean getHull()
	{
		return HullUp;
	}
}