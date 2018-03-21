
package colin.game.core.chanzi;

import java.awt.Graphics;

import colin.game.游戏状态;
import colin.game.core.dikuai.Test地块;

public class Test铲子 extends Test地块
{
	//f
	铲子 cz = new 铲子();
	//c
	public Test铲子()
	{
 		 
	}
	//m
	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		switch (gameZT) 
		{
		case    选卡片:
			break;
		default: 
			cz.xianShi(g);
			break;
		}
	}
	@Override
	protected void 鼠标左键单击(int mx, int my, int clickcount)
	{
		// TODO Auto-generated method stub
		//super.鼠标左键单击(mx, my, clickcount);
		super.鼠标左键单击(mx, my, clickcount);
		switch (gameZT) 
		{
		case    正常进行:
			
			if (cz.anWo(mx, my)) 
			{
				gameZT = 游戏状态.挖掉植物;
			} 
			break;
		case    挖掉植物:
			cz.waDiao(kuais[cz.getHang()][cz.getLie()]);
			gameZT = 游戏状态.正常进行;
			break;
			
		default: 
			break;
		}
	}
	
	@Override
	protected void 鼠标移动(int mx, int my)
	{
	
		if (gameZT == 游戏状态.挖掉植物) 
		{
			cz.tuoDong(mx, my);
		} 
		else
		{
			super.鼠标移动(mx, my);
		}
	}
	
	@Override
	protected void 鼠标右键单击(int mx, int my)
	{
		// TODO Auto-generated method stub
		
		switch (gameZT) 
		{
		case    挖掉植物:
			cz.setZt(铲子状态.待用);
			cz.fangHui();
			gameZT=游戏状态.正常进行;
			break;
		default: 
			super.鼠标右键单击(mx, my);
			break;
		}
	}
	
	public static void main(String[] args)
	{
		  new Test铲子();
	}
	
}
