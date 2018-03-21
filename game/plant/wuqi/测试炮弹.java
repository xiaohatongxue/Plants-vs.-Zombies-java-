
package colin.game.plant.wuqi;

import java.awt.Graphics;

import colin.game.core.植物僵尸Game;
import colin.game.zombie.普通僵尸;

public class 测试炮弹 extends 植物僵尸Game
{
	//F
	绿豆 ld = new 绿豆(100, 100, 弹药状态.前飞行);
	普通僵尸  js = new 普通僵尸(); 
	//C
	 public 测试炮弹()
	{
		 js.qianJin();
	}
	 
	 //M
	 
	 
	 
	 public static void main(String[] args)
	{
		new 测试炮弹();
		
	}

	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		js.xianShi(g);
		ld.xianShi(g);
	}

	@Override
	protected void 全局定时()
	{
		super.全局定时();
		ld.run();
		js.run();
		if ( ld.isSiLe()==false&&ld.getRect().intersects(js.getRect()) )  
		{
			ld.baoZhao(js);
		} 
	}

 

	@Override
	protected void 鼠标左键单击(int mx, int my, int clickcount)
	{
		super.鼠标左键单击(mx, my, clickcount);
		ld = new 绿豆(mx, my, 弹药状态.前飞行);
	}
	
	
}
