
package colin.game.zombie;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import colin.game.core.ֲ�ｩʬGame;
import colin.game.plant.xrk.���տ�;

public class Test��ʬ extends ֲ�ｩʬGame
{
	//f
	��ͨ��ʬ js1 = new ��ͨ��ʬ();
	//c
	 public Test��ʬ()
	{
		// TODO Auto-generated constructor stub
	 
	}	
	 
	 @Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);//���ø������ʾ
		js1.xianShi(g);
 
	}
	 
	 @Override
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		js1.run();
 
	}
	 
	//m
	 @Override
	protected void ���̰���(int keyCode)
	{
		super.���̰���(keyCode);
		switch (keyCode) 
		{
		case    KeyEvent.VK_1:
			js1.dengDai();
			break;
		case    KeyEvent.VK_2:
			js1.qianJin();
			break;
		case    KeyEvent.VK_3:
			js1.wuTouQianJin();
			break;
		case    KeyEvent.VK_4:
			js1.touDiao();
			break;
		case    KeyEvent.VK_5:
			js1.gongJi(new ���տ�());
			break;
		case    KeyEvent.VK_6:
			js1.wuTouGongJi(null);
			break;
		case    KeyEvent.VK_7:
			js1.beiGongJi();
			break;
		case    KeyEvent.VK_8:
			js1.zhaSi();
			break;
		case    KeyEvent.VK_9:
			js1.siDiao();
			break;
			
		default: 
			break;
		}
	}

	public static void main(String[] args)
	{
		new Test��ʬ();
	}

}
