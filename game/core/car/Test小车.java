
package colin.game.core.car;

import java.awt.Graphics;

import colin.game.core.ֲ�ｩʬGame;

public class TestС�� extends ֲ�ｩʬGame
{
	С�� che = new С��(0, 100);

	@Override
	protected void ȫ����ʾ(Graphics g)
	{
		super.ȫ����ʾ(g);
		che.xianShi(g);
	}

	@Override
	protected void ȫ�ֶ�ʱ()
	{
		super.ȫ�ֶ�ʱ();
		che.run();
	}

	@Override
	protected void ���̰���(int keyCode)
	{
		che.setKaiDong(true);
	}
	
	public static void main(String[] args)
	{
		new TestС��();
	}

}
