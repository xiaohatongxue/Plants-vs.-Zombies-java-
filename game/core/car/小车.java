
package colin.game.core.car;

import java.awt.Graphics;

import colin.game.core.GameFramework;
import colin.game.core.����;

public class С�� extends ����
{
	/**
	 * С��������
	 */
	private boolean kaiDong;
	
	public С��(int x, int y)
	{
		this.x = x;
		this.y = y;
		rect = new int[]{0,0,70,57 };
	}

	@Override
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/С��.png", x, y, g);
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
