

package colin.game.plant.douban;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.core.chanzi.Test铲子;
import colin.game.plant.植物状态;
import colin.game.plant.wuqi.弹药;
import colin.game.plant.xrk.向日葵;
import colin.game.zombie.普通僵尸;

public class Test豆瓣 extends Test铲子
{
	//field属性
	普通僵尸[] jss = new  普通僵尸[10];
	
	ArrayList<弹药> list = new ArrayList<弹药>();
	//费炮弹 回收
	ArrayList<弹药> feiList = new ArrayList<弹药>();

	//constructor构造器
	public Test豆瓣()
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
		new Test豆瓣();
	}


	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		for (int i = 0; i < jss.length; i++)
		{
			if (jss[i].isSiLe()==false) 
			{
				jss[i].xianShi(g);
			} 
		}
		
		for (int xb = 0; xb <list.size(); xb++)
		{
			list.get(xb).xianShi(g);
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
		
		for (int xb = 0; xb <list.size(); xb++)
		{
			list.get(xb).run();
		}
		
		//--检测僵尸与植物的碰撞关系
		
		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 9; l++)
			{
				if (  kuais[h][l].getZhiWu()!=null
						&& kuais[h][l].getZhiWu() instanceof 豆瓣)  
				{	
					豆瓣 zw =   (豆瓣) kuais[h][l].getZhiWu();
					zw.faShePaoDan();
					ArrayList<弹药> dy = zw.getListDanYao();//从豆瓣里把弹药拿出来
					list.addAll(dy);
				} 
			}
		}
		
		//-------------子弹打中僵尸------------------------------
		for (int i = 0; i < jss.length; i++)
		{
			for (int j = 0; j < list.size(); j++)
			{
				if (   jss[i].isSiLe()==false&& jss[i].getRect().intersects(   list.get(j) .getRect() ) ) 
				{
					list.get(j).baoZhao(  jss[i]);
				} 
			}
		}
		//回收 费炮弹
		for (int i = 0; i < list.size(); i++)
		{
			弹药 pd = list.get(i);
			if (pd.isSiLe()==true|| pd.getX()>850  ) 
			{
				feiList.add(pd);
			} 
		}
		//把费炮弹 从好炮弹中去掉
		list.removeAll(feiList  );
		
	}
}
