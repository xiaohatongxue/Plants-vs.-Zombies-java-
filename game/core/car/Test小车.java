
package colin.game.core.car;

import java.awt.Graphics;

import colin.game.core.植物僵尸Game;

public class Test小车 extends 植物僵尸Game
{
	小车 che = new 小车(0, 100);

	@Override
	protected void 全局显示(Graphics g)
	{
		super.全局显示(g);
		che.xianShi(g);
	}

	@Override
	protected void 全局定时()
	{
		super.全局定时();
		che.run();
	}

	@Override
	protected void 键盘按下(int keyCode)
	{
		che.setKaiDong(true);
	}
	
	public static void main(String[] args)
	{
		new Test小车();
	}

}
