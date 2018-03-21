
package colin.game.plant.xrk;

import java.awt.Graphics;

import colin.game.core.sun.Test阳光;
import colin.game.core.sun.阳光;
import colin.game.core.sun.阳光状态;

public class Test向日葵 extends Test阳光
{
	//f
	//c
	public Test向日葵()
	{
		 
	}
	//m
	public static void main(String[] args)
	{
		new Test向日葵();
	}

	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
	}

	@Override
	protected void 全局定时()
	{
		super.全局定时();
		管理阳光();
		自动收集阳光();
	}

	void 自动收集阳光()
	{
		for (int i = 0; i <list.size(); i++)
		{
			阳光 yg = list.get(i);
			if (yg.isSiLe()==false&&yg.getZt()==阳光状态.到位) 
			{
				if (	yg.jianQiLai()==true) 
				{
					zhiWus.zengJia(50);
				} 
			} 
		}
	}

	/**
	 * 管理从向日葵产生的阳光
	 */
	void 管理阳光()
	{
		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 9; l++)
			{
				if (  kuais[h][l].getZhiWu()!=null
						&& kuais[h][l].getZhiWu() instanceof 向日葵)  
				{	
					向日葵 xrk = (向日葵) kuais[h][l].getZhiWu();
					阳光 yg = xrk.getYg();
					if (yg!=null) 
					{
						list.add(yg);
					} 
				} 
			}
		}
	}
}
