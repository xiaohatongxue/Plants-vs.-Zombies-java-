
package colin.game.core;

import java.awt.Color;
import java.awt.Graphics;

import colin.game.游戏状态;

public class 植物僵尸Game extends GameFramework
{
	protected 游戏状态 gameZT = 游戏状态.选卡片;
	
	public 植物僵尸Game()
	{
		super(800, 600, 100);
	}
	
	@Override
	protected void 全局显示(Graphics g)
	{
		 drawImage("images/背景/background1.jpg", -200, 0, g);
	 
		//设置透明颜色                   红  绿  蓝  透明度
//		Color color = new Color(0, 0, 0, 160);
//		g.setColor(color);
//		g.fillRect(0, 0, 40, 80);
	}
	
	 
	public static void main(String[] args)
	{
		植物僵尸Game game = new 植物僵尸Game();
	}
}
