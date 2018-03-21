
package colin.game.zombie;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import colin.game.core.植物僵尸Game;
import colin.game.plant.xrk.向日葵;

public class Test僵尸 extends 植物僵尸Game
{
	//f
	普通僵尸 js1 = new 普通僵尸();
	//c
	 public Test僵尸()
	{
		// TODO Auto-generated constructor stub
	 
	}	
	 
	 @Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);//调用父类的显示
		js1.xianShi(g);
 
	}
	 
	 @Override
	protected void 全局定时()
	{
		super.全局定时();
		js1.run();
 
	}
	 
	//m
	 @Override
	protected void 键盘按下(int keyCode)
	{
		super.键盘按下(keyCode);
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
			js1.gongJi(new 向日葵());
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
		new Test僵尸();
	}

}
