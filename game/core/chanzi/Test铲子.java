
package colin.game.core.chanzi;

import java.awt.Graphics;

import colin.game.��Ϸ״̬;
import colin.game.core.dikuai.Test�ؿ�;

public class Test���� extends Test�ؿ�
{
	//f
	���� cz = new ����();
	//c
	public Test����()
	{
 		 
	}
	//m
	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
		switch (gameZT) 
		{
		case    ѡ��Ƭ:
			break;
		default: 
			cz.xianShi(g);
			break;
		}
	}
	@Override
	protected void ����������(int mx, int my, int clickcount)
	{
		// TODO Auto-generated method stub
		//super.����������(mx, my, clickcount);
		super.����������(mx, my, clickcount);
		switch (gameZT) 
		{
		case    ��������:
			
			if (cz.anWo(mx, my)) 
			{
				gameZT = ��Ϸ״̬.�ڵ�ֲ��;
			} 
			break;
		case    �ڵ�ֲ��:
			cz.waDiao(kuais[cz.getHang()][cz.getLie()]);
			gameZT = ��Ϸ״̬.��������;
			break;
			
		default: 
			break;
		}
	}
	
	@Override
	protected void ����ƶ�(int mx, int my)
	{
	
		if (gameZT == ��Ϸ״̬.�ڵ�ֲ��) 
		{
			cz.tuoDong(mx, my);
		} 
		else
		{
			super.����ƶ�(mx, my);
		}
	}
	
	@Override
	protected void ����Ҽ�����(int mx, int my)
	{
		// TODO Auto-generated method stub
		
		switch (gameZT) 
		{
		case    �ڵ�ֲ��:
			cz.setZt(����״̬.����);
			cz.fangHui();
			gameZT=��Ϸ״̬.��������;
			break;
		default: 
			super.����Ҽ�����(mx, my);
			break;
		}
	}
	
	public static void main(String[] args)
	{
		  new Test����();
	}
	
}
