
package colin.game.core.chanzi;

import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.GameFramework;
import colin.game.core.dikuai.�ؿ�;

public class ����
{
	//f
	private int x;
	private int y;
	private ����״̬ zt  = ����״̬.����;
	private int	lie;
	private int	hang;
	//c
	public ����()
	{
		fangHui();
	}
	/**
	 * 
	 */
	public void fangHui()
	{
		x=453;
		y =3;
	}
	//m
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/ShovelBank.png", 446, 0, g);
		GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/С����.png", x, y, g);
	}
	
	public void tuoDong(int mx,int my)
	{
		  lie = (mx - 45) / 82;
		  hang = (my - 73) / 100;
		  x = lie * 82 + 45;
		  y = hang * 100 + 73;
	}
	
	public void waDiao( �ؿ� dq )
	{
		dq.setZw(null);
		fangHui();
	}
	
	public boolean anWo(int mx,int my)
	{
		Rectangle rect = new Rectangle(453,3,59,63);
		return rect.contains(mx,my);
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public ����״̬ getZt()
	{
		return zt;
	}
	public void setZt(����״̬ zt)
	{
		this.zt = zt;
	}
	public int getLie()
	{
		return lie;
	}
	public void setLie(int lie)
	{
		this.lie = lie;
	}
	public int getHang()
	{
		return hang;
	}
	public void setHang(int hang)
	{
		this.hang = hang;
	}
}
