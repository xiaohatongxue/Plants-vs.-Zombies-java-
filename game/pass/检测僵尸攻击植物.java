
package colin.game.pass;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.��Ϸ״̬;
import colin.game.core.car.С��;
import colin.game.core.dikuai.Test�ؿ�;
import colin.game.plant.xrk.Test���տ�;
import colin.game.zombie.��ͨ��ʬ;

public class ��⽩ʬ����ֲ�� extends Test���տ�
{
	//f
	ArrayList<��ͨ��ʬ> list = new ArrayList<��ͨ��ʬ>();
	
	int hang = 3;
	
	С�� che = new С��(0, 100*hang+100);
	//c
	
	//m

	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
		if (gameZT!=��Ϸ״̬.ѡ��Ƭ) 
		{
			for (int i = 0; i < list.size(); i++)
			{
				list.get(i).xianShi(g);
			}
			che.xianShi(g);
		} 

	}

	@Override
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).run();
		}
		��⽩ʬ����ֲ��();
	
		if (che.isKaiDong()) 
		{
			che.run();
		} 
		else
		{
			��ʬ����();
		}
		��⳵ײ��ʬ();
		�����Ѿ������Ľ�ʬ();
	}

	private void �����Ѿ������Ľ�ʬ()
	{
		ArrayList<��ͨ��ʬ> lin = new ArrayList<��ͨ��ʬ>();
		for (int xb = 0; xb < list.size(); xb++)
		{
			if (list.get(xb).isSiLe()) 
			{
				lin.add(list.get(xb));
			} 
		}
		list.removeAll(lin);
	}

	private void ��ʬ����()
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getRect().intersects(che.getRect())) 
			{
				che.setKaiDong(true);
			} 
		}
	}

	private void ��⳵ײ��ʬ()
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
	protected void ���̰���(int keyCode)
	{
		super.���̰���(keyCode);
		��ͨ��ʬ js = new ��ͨ��ʬ();
		js.qianJin();
		
		js.setY(30+hang*100);
		list.add(js);
	}
	
	void ��⽩ʬ����ֲ��()
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
		new ��⽩ʬ����ֲ��();
	}
}
