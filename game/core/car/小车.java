
package colin.game.core.car;

import java.awt.Graphics;

import colin.game.core.GameFramework;
import colin.game.core.精灵;

public class 小车 extends 精灵
{
	/**
	 * 小车开动吗
	 */
	private boolean kaiDong;
	
	public 小车(int x, int y)
	{
		this.x = x;
		this.y = y;
		rect = new int[]{0,0,70,57 };
	}

	@Override
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/小车.png", x, y, g);
	}

	@Override
	public void run()
	{
		if (siLe) 
		{
			return ;
		} 
		if (   x>1000  ) 
		{
			 
			siLe=true;
			return ;
		} 
		else if(  kaiDong==true)
		{
			x+=20;
		}
	}


	public boolean isKaiDong()
	{
		return kaiDong;
	}


	public void setKaiDong(boolean kaiDong)
	{
		this.kaiDong = kaiDong;
	}
}
