

package colin.game.plant.douban;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.core.chanzi.Test����;
import colin.game.plant.ֲ��״̬;
import colin.game.plant.wuqi.��ҩ;
import colin.game.plant.xrk.���տ�;
import colin.game.zombie.��ͨ��ʬ;

public class Test���� extends Test����
{
	//field����
	��ͨ��ʬ[] jss = new  ��ͨ��ʬ[10];
	
	ArrayList<��ҩ> list = new ArrayList<��ҩ>();
	//���ڵ� ����
	ArrayList<��ҩ> feiList = new ArrayList<��ҩ>();

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
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		for (int i = 0; i < jss.length; i++)
		{
			jss[i].run();
		}
		
		for (int xb = 0; xb <list.size(); xb++)
		{
			list.get(xb).run();
		}
		
		//--��⽩ʬ��ֲ�����ײ��ϵ
		
		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 9; l++)
			{
				if (  kuais[h][l].getZhiWu()!=null
						&& kuais[h][l].getZhiWu() instanceof ����)  
				{	
					���� zw =   (����) kuais[h][l].getZhiWu();
					zw.faShePaoDan();
					ArrayList<��ҩ> dy = zw.getListDanYao();//�Ӷ�����ѵ�ҩ�ó���
					list.addAll(dy);
				} 
			}
		}
		
		//-------------�ӵ����н�ʬ------------------------------
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
		//���� ���ڵ�
		for (int i = 0; i < list.size(); i++)
		{
			��ҩ pd = list.get(i);
			if (pd.isSiLe()==true|| pd.getX()>850  ) 
			{
				feiList.add(pd);
			} 
		}
		//�ѷ��ڵ� �Ӻ��ڵ���ȥ��
		list.removeAll(feiList  );
		
	}
}
