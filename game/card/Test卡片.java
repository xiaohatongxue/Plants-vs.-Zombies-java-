
package colin.game.card;

import java.awt.Graphics;

import colin.game.游戏状态;
import colin.game.core.植物僵尸Game;
import colin.game.plant.植物;

public class Test卡片 extends 植物僵尸Game
{
	//f
	protected 卡片选区 kpq = new 卡片选区(6, 卡片.names.length);
	protected 植物选择区 zhiWus = null;
	/**
	 * 正要被种植的植物
	 */
	protected 植物 zw; 

	
	//c

	//m
	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		if (kpq!=null) 
		{
			kpq.xianShi(g);
		} 
		if (zhiWus!=null) 
		{
			zhiWus.xianShi(g);
		} 
		if (zw!=null) 
		{
			zw.xianShi(g);
		} 
	}
	
	
	
	@Override
	protected void 鼠标左键单击(int mx, int my, int clickcount)
	{
		switch (gameZT) 
		{
		case    选卡片:
			if (kpq!=null) 
			{
				kpq.anWo(mx, my);
				if (kpq.getZt() == 卡片选区状态.选择完成) 
				{
					zhiWus = new 植物选择区(kpq.getKas());
					kpq = null;
					gameZT = 游戏状态.正常进行;
				} 
			}
			break;
		case    正常进行:
			if (zhiWus!=null) 
			{
				zw = zhiWus.xuanZeKaPian(mx, my);
				if (zw!=null) 
				{
					zw.setX(mx);
					zw.setY(my);
					gameZT=游戏状态.准备种植;
				} 
			}
			break;
		default: 
			break;
		}
	}

	@Override
	protected void 全局定时()
	{
		if (zhiWus!=null) 
		{
			zhiWus.run();
		} 
	}

	@Override
	protected void 鼠标右键单击(int mx, int my)
	{
		super.鼠标右键单击(mx, my);
		zw = null;
		zhiWus.huanYuan();
		gameZT = 游戏状态.正常进行;
	}

	public static void main(String[] args)
	{
		new Test卡片();
	}
	
	
}
