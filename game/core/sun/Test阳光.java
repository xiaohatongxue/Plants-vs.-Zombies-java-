
package colin.game.core.sun;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.游戏状态;
import colin.game.core.chanzi.Test铲子;
import colin.game.core.dikuai.Test地块;

public class Test阳光 extends Test铲子
{
	//f
	protected ArrayList<阳光> list = new ArrayList<阳光>();
	//f
		private int shiJian = 0 ;
	//c
	
	//m
	public static void main(String[] args)
	{
		new Test阳光();
	}

	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).xianShi(g);
		}
	}

	@Override
	protected void 全局定时()
	{
		super.全局定时();
		if (gameZT==游戏状态.选卡片) 
		{
			return ;
		} 
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).run();
		}
		if ( shiJian==100) 
		{
			shiJian = 0;
			list.add(new 阳光());
		} 
		else
		{
			shiJian++;
		}
	}

	@Override
	protected void 鼠标左键单击(int mx, int my, int clickcount)
	{
		// TODO Auto-generated method stub
		super.鼠标左键单击(mx, my, clickcount);
		for (int i = 0; i <list.size(); i++)
		{
			if (list.get(i).anWo(mx, my)) 
			{
				zhiWus.zengJia(50);
				return ;
			} 
		}
	}
}
