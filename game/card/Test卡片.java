
package colin.game.card;

import java.awt.Graphics;

import colin.game.��Ϸ״̬;
import colin.game.core.ֲ�ｩʬGame;
import colin.game.plant.ֲ��;

public class Test��Ƭ extends ֲ�ｩʬGame
{
	//f
	protected ��Ƭѡ�� kpq = new ��Ƭѡ��(6, ��Ƭ.names.length);
	protected ֲ��ѡ���� zhiWus = null;
	/**
	 * ��Ҫ����ֲ��ֲ��
	 */
	protected ֲ�� zw; 

	
	//c

	//m
	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
		if (kpq!=null) 
		{
			kpq.xianShi(g);
		} 
		if (zhiWus!=null) 
		{
			zhiWus.xianShi(g);
		} 
		if (zw!=null) 
		{
			zw.xianShi(g);
		} 
	}
	
	
	
	@Override
	protected void ����������(int mx, int my, int clickcount)
	{
		switch (gameZT) 
		{
		case    ѡ��Ƭ:
			if (kpq!=null) 
			{
				kpq.anWo(mx, my);
				if (kpq.getZt() == ��Ƭѡ��״̬.ѡ�����) 
				{
					zhiWus = new ֲ��ѡ����(kpq.getKas());
					kpq = null;
					gameZT = ��Ϸ״̬.��������;
				} 
			}
			break;
		case    ��������:
			if (zhiWus!=null) 
			{
				zw = zhiWus.xuanZeKaPian(mx, my);
				if (zw!=null) 
				{
					zw.setX(mx);
					zw.setY(my);
					gameZT=��Ϸ״̬.׼����ֲ;
				} 
			}
			break;
		default: 
			break;
		}
	}

	@Override
	protected void ȫ�ֶ�ʱ()
	{
		if (zhiWus!=null) 
		{
			zhiWus.run();
		} 
	}

	@Override
	protected void ����Ҽ�����(int mx, int my)
	{
		super.����Ҽ�����(mx, my);
		zw = null;
		zhiWus.huanYuan();
		gameZT = ��Ϸ״̬.��������;
	}

	public static void main(String[] args)
	{
		new Test��Ƭ();
	}
	
	
}
