
package colin.game.plant.lj;

import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.chanzi.Test铲子;
import colin.game.plant.xrk.向日葵;
import colin.game.zombie.普通僵尸;

public class Test辣椒 extends Test铲子
{
	//field属性
	普通僵尸[] jss = new  普通僵尸[10];

	//constructor构造器
	public Test辣椒()
	{
		for (int i = 0; i < jss.length; i++)
		{
			jss[i] = new 普通僵尸();
			jss[i].qianJin();
		}
	}
	//method方法

	
	public static void main(String[] args)
	{
		new Test辣椒();
	}


	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		for (int i = 0; i < jss.length; i++)
		{
			jss[i].xianShi(g);
		}
	}


	@Override
	protected void 全局定时()
	{
		super.全局定时();
		for (int i = 0; i < jss.length; i++)
		{
			jss[i].run();
		}
		//--检测僵尸与植物的碰撞关系
		
		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 9; l++)
			{
				if (  kuais[h][l].getZhiWu()!=null
						&& kuais[h][l].getZhiWu() instanceof 红辣椒)  
				{	
					红辣椒 zw =   (红辣椒) kuais[h][l].getZhiWu();
					
					for (int i = 0; i < jss.length; i++)
					{
						if ( jss[i].isSiLe()==false && jss[i].getRect().intersects(   new Rectangle(  45,zw.getHang()*100+73,755,100 )   )    ) 
						{
							jss[i].zhaSi();
						} 
					}
					
				} 
			}
		}
		
	}
}
