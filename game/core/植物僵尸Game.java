
package colin.game.core;

import java.awt.Color;
import java.awt.Graphics;

import colin.game.��Ϸ״̬;

public class ֲ�ｩʬGame extends GameFramework
{
	protected ��Ϸ״̬ gameZT = ��Ϸ״̬.ѡ��Ƭ;
	
	public ֲ�ｩʬGame()
	{
		super(800, 600, 100);
	}
	
	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		 drawImage("images/����/background1.jpg", -200, 0, g);
	 
		//����͸����ɫ                   ��  ��  ��  ͸����
//		Color color = new Color(0, 0, 0, 160);
//		g.setColor(color);
//		g.fillRect(0, 0, 40, 80);
	}
	
	 
	public static void main(String[] args)
	{
		ֲ�ｩʬGame game = new ֲ�ｩʬGame();
	}
}
