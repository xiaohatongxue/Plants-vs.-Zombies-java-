

package colin.game.pass;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import colin.game.core.ֲ�ｩʬGame;

public class ����ѵ��ģ�� extends ֲ�ｩʬGame
{
	//field����

	//constructor������
	public ����ѵ��ģ��()
	{
		
	}
	//method����
	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
	}


	@Override
	protected void ���̰���(int keyCode)
	{
		super.���̰���(keyCode);
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
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
	}
	
	
	public static void main(String[] args)
	{
		new ����ѵ��ģ��();
	}

}
