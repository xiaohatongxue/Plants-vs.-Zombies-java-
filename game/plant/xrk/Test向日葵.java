
package colin.game.plant.xrk;

import java.awt.Graphics;

import colin.game.core.sun.Test����;
import colin.game.core.sun.����;
import colin.game.core.sun.����״̬;

public class Test���տ� extends Test����
{
	//f
	//c
	public Test���տ�()
	{
		 
	}
	//m
	public static void main(String[] args)
	{
		new Test���տ�();
	}

	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
	}

	@Override
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		��������();
		�Զ��ռ�����();
	}

	void �Զ��ռ�����()
	{
		for (int i = 0; i <list.size(); i++)
		{
			���� yg = list.get(i);
			if (yg.isSiLe()==false&&yg.getZt()==����״̬.��λ) 
			{
				if (	yg.jianQiLai()==true) 
				{
					zhiWus.zengJia(50);
				} 
			} 
		}
	}

	/**
	 * ��������տ�����������
	 */
	void ��������()
	{
		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 9; l++)
			{
				if (  kuais[h][l].getZhiWu()!=null
						&& kuais[h][l].getZhiWu() instanceof ���տ�)  
				{	
					���տ� xrk = (���տ�) kuais[h][l].getZhiWu();
					���� yg = xrk.getYg();
					if (yg!=null) 
					{
						list.add(yg);
					} 
				} 
			}
		}
	}
}
