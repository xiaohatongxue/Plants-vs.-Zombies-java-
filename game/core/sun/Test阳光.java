
package colin.game.core.sun;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.��Ϸ״̬;
import colin.game.core.chanzi.Test����;
import colin.game.core.dikuai.Test�ؿ�;

public class Test���� extends Test����
{
	//f
	protected ArrayList<����> list = new ArrayList<����>();
	//f
		private int shiJian = 0 ;
	//c
	
	//m
	public static void main(String[] args)
	{
		new Test����();
	}

	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).xianShi(g);
		}
	}

	@Override
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		if (gameZT==��Ϸ״̬.ѡ��Ƭ) 
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
			list.add(new ����());
		} 
		else
		{
			shiJian++;
		}
	}

	@Override
	protected void ����������(int mx, int my, int clickcount)
	{
		// TODO Auto-generated method stub
		super.����������(mx, my, clickcount);
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
