
package colin.game.core.dikuai;

import java.awt.Graphics;

import colin.game.��Ϸ״̬;
import colin.game.card.Test��Ƭ;
import colin.game.plant.ֲ��״̬;

public class Test�ؿ� extends Test��Ƭ
{
	//f
	protected �ؿ�[][] kuais = new �ؿ�[5][9];
 
	//c
	public Test�ؿ�()
	{
		for (int h = 0; h < kuais.length; h++)
		{
			for (int l = 0; l < kuais[h].length; l++)
			{
				kuais[h][l] = new �ؿ�(h, l);
			}
		}

	}
	//m
	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		// TODO Auto-generated method stub
		super.ȫ����ʾ(g);
		for (int h = 0; h < kuais.length; h++)
		{
			for (int l = 0; l < kuais[h].length; l++)
			{
				kuais[h][l].xianShi(g);
			}
		}
	}
	
	
	
	@Override
	protected void ȫ�ֶ�ʱ()  
	{
		super.ȫ�ֶ�ʱ();
		for (int h = 0; h < kuais.length; h++)
		{
			for (int l = 0; l < kuais[h].length; l++)
			{
				kuais[h][l].run();
			}
		}
	}

	@Override
	protected void ����ƶ�(int mx, int my)
	{
		super.����ƶ�(mx, my);
		int lie = (mx - 45) / 82;
		int hang = (my - 73) / 100;
		if (hang>5||lie>9) 
		{
			return ;
		} 
		switch (gameZT ) 
		{
		case    ׼����ֲ:
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
	protected void ����������(int mx, int my, int clickcount)
	{
		// TODO Auto-generated method stub
		
		switch (gameZT) 
		{
		case    ׼����ֲ:
			if (zw==null) 
			{
				return ;
			} 
			int lie = (mx - 45) / 82;
			int hang = (my - 73) / 100;
			if (kuais[hang][lie].getZhiWu() == null)
			{
				zw.setZt(ֲ��״̬.�ֺ�);
				kuais[hang][lie].setZw(zw);
			}
			zw = null;
			gameZT = ��Ϸ״̬.��������;
			break;
		default: 
			super.����������(mx, my, clickcount);
			break;
		}
		
		
	}
 
	
	
	public static void main(String[] args)
	{
		new Test�ؿ�();
	}
	
}
