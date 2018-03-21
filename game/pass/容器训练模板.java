

package colin.game.pass;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import colin.game.core.植物僵尸Game;

public class 容器训练模板 extends 植物僵尸Game
{
	//field属性

	//constructor构造器
	public 容器训练模板()
	{
		
	}
	//method方法
	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
	}


	@Override
	protected void 键盘按下(int keyCode)
	{
		super.键盘按下(keyCode);
		switch (keyCode) 
		{
		case    KeyEvent.VK_A:
			
			break;
		case    KeyEvent.VK_B:
			
			break;
		case    KeyEvent.VK_C:
			
			break;
		case    KeyEvent.VK_D:
			
			break;
		case    KeyEvent.VK_E:
			
			break;
		default: 
			break;
		}
	}


	@Override
	protected void 全局定时()
	{
		super.全局定时();
	}
	
	
	public static void main(String[] args)
	{
		new 容器训练模板();
	}

}
