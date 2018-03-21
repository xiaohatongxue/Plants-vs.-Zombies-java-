
package colin.game.pass;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.游戏状态;
import colin.game.core.car.小车;
import colin.game.core.dikuai.Test地块;
import colin.game.plant.xrk.Test向日葵;
import colin.game.zombie.普通僵尸;

public class 检测僵尸攻击植物 extends Test向日葵
{
	//f
	ArrayList<普通僵尸> list = new ArrayList<普通僵尸>();
	
	int hang = 3;
	
	小车 che = new 小车(0, 100*hang+100);
	//c
	
	//m

	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		if (gameZT!=游戏状态.选卡片) 
		{
			for (int i = 0; i < list.size(); i++)
			{
				list.get(i).xianShi(g);
			}
			che.xianShi(g);
		} 

	}

	@Override
	protected void 全局定时()
	{
		super.全局定时();
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).run();
		}
		检测僵尸攻击植物();
	
		if (che.isKaiDong()) 
		{
			che.run();
		} 
		else
		{
			僵尸碰车();
		}
		检测车撞僵尸();
		清理已经死掉的僵尸();
	}

	private void 清理已经死掉的僵尸()
	{
		ArrayList<普通僵尸> lin = new ArrayList<普通僵尸>();
		for (int xb = 0; xb < list.size(); xb++)
		{
			if (list.get(xb).isSiLe()) 
			{
				lin.add(list.get(xb));
			} 
		}
		list.removeAll(lin);
	}

	private void 僵尸碰车()
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getRect().intersects(che.getRect())) 
			{
				che.setKaiDong(true);
			} 
		}
	}

	private void 检测车撞僵尸()
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getRect().intersects(che.getRect())) 
			{
				list.get(i).siDiao();
			} 
		}
	}

	@Override
	protected void 键盘按下(int keyCode)
	{
		super.键盘按下(keyCode);
		普通僵尸 js = new 普通僵尸();
		js.qianJin();
		
		js.setY(30+hang*100);
		list.add(js);
	}
	
	void 检测僵尸攻击植物()
	{
//		for (int h = 0; h < 5; h++)
//		{
			for (int l = 0; l < 9; l++)
			{
				if ( kuais[hang][l].getZhiWu()!=null ) 
				{
					for (int i = 0; i <list.size(); i++)
					{
						if ( kuais[hang][l].getZhiWu().getRect().intersects(list.get(i).getRect())) 
						{
							list.get(i).gongJi(kuais[hang][l].getZhiWu() );
						} 
					}
				} 
			}
		//}
	}
	
	public static void main(String[] args)
	{
		new 检测僵尸攻击植物();
	}
}
