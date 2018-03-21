
package colin.game.core.dikuai;

import java.awt.Graphics;

import colin.game.游戏状态;
import colin.game.card.Test卡片;
import colin.game.plant.植物状态;

public class Test地块 extends Test卡片
{
	//f
	protected 地块[][] kuais = new 地块[5][9];
 
	//c
	public Test地块()
	{
		for (int h = 0; h < kuais.length; h++)
		{
			for (int l = 0; l < kuais[h].length; l++)
			{
				kuais[h][l] = new 地块(h, l);
			}
		}

	}
	//m
	@Override
	protected void 全局显示(Graphics g)
	{
		// TODO Auto-generated method stub
		super.全局显示(g);
		for (int h = 0; h < kuais.length; h++)
		{
			for (int l = 0; l < kuais[h].length; l++)
			{
				kuais[h][l].xianShi(g);
			}
		}
	}
	
	
	
	@Override
	protected void 全局定时()  
	{
		super.全局定时();
		for (int h = 0; h < kuais.length; h++)
		{
			for (int l = 0; l < kuais[h].length; l++)
			{
				kuais[h][l].run();
			}
		}
	}

	@Override
	protected void 鼠标移动(int mx, int my)
	{
		super.鼠标移动(mx, my);
		int lie = (mx - 45) / 82;
		int hang = (my - 73) / 100;
		if (hang>5||lie>9) 
		{
			return ;
		} 
		switch (gameZT ) 
		{
		case    准备种植:
			if (zw!=null&&kuais[hang][lie].getZhiWu() == null )
			{
				int x = lie * 82 + 45;
				int y = hang * 100 + 73;
				zw.setX(x);
				zw.setY(y);
			}
			break;
		default: 
			break;
		}

	}

	@Override
	protected void 鼠标左键单击(int mx, int my, int clickcount)
	{
		// TODO Auto-generated method stub
		
		switch (gameZT) 
		{
		case    准备种植:
			if (zw==null) 
			{
				return ;
			} 
			int lie = (mx - 45) / 82;
			int hang = (my - 73) / 100;
			if (kuais[hang][lie].getZhiWu() == null)
			{
				zw.setZt(植物状态.种好);
				kuais[hang][lie].setZw(zw);
			}
			zw = null;
			gameZT = 游戏状态.正常进行;
			break;
		default: 
			super.鼠标左键单击(mx, my, clickcount);
			break;
		}
		
		
	}
 
	
	
	public static void main(String[] args)
	{
		new Test地块();
	}
	
}
