
package colin.game.plant.lj;

import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.chanzi.Test����;
import colin.game.plant.xrk.���տ�;
import colin.game.zombie.��ͨ��ʬ;

public class Test���� extends Test����
{
	//field����
	��ͨ��ʬ[] jss = new  ��ͨ��ʬ[10];

	//constructor������
	public Test����()
	{
		for (int i = 0; i < jss.length; i++)
		{
			jss[i] = new ��ͨ��ʬ();
			jss[i].qianJin();
		}
	}
	//method����

	
	public static void main(String[] args)
	{
		new Test����();
	}


	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
		for (int i = 0; i < jss.length; i++)
		{
			jss[i].xianShi(g);
		}
	}


	@Override
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		for (int i = 0; i < jss.length; i++)
		{
			jss[i].run();
		}
		//--��⽩ʬ��ֲ�����ײ��ϵ
		
		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 9; l++)
			{
				if (  kuais[h][l].getZhiWu()!=null
						&& kuais[h][l].getZhiWu() instanceof ������)  
				{	
					������ zw =   (������) kuais[h][l].getZhiWu();
					
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
