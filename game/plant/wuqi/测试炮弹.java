
package colin.game.plant.wuqi;

import java.awt.Graphics;

import colin.game.core.ֲ�ｩʬGame;
import colin.game.zombie.��ͨ��ʬ;

public class �����ڵ� extends ֲ�ｩʬGame
{
	//F
	�̶� ld = new �̶�(100, 100, ��ҩ״̬.ǰ����);
	��ͨ��ʬ  js = new ��ͨ��ʬ(); 
	//C
	 public �����ڵ�()
	{
		 js.qianJin();
	}
	 
	 //M
	 
	 
	 
	 public static void main(String[] args)
	{
		new �����ڵ�();
		
	}

	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
		js.xianShi(g);
		ld.xianShi(g);
	}

	@Override
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		ld.run();
		js.run();
		if ( ld.isSiLe()==false&&ld.getRect().intersects(js.getRect()) )  
		{
			ld.baoZhao(js);
		} 
	}

 

	@Override
	protected void ����������(int mx, int my, int clickcount)
	{
		super.����������(mx, my, clickcount);
		ld = new �̶�(mx, my, ��ҩ״̬.ǰ����);
	}
	
	
}
