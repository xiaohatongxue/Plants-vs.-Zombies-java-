

package colin.game.plant.wuqi;

import java.awt.Graphics;

import colin.game.core.GameFramework;
import colin.game.zombie.��ͨ��ʬ;

public class �̶� extends ��ҩ
{

	public �̶�( int x,int y,��ҩ״̬ zt )
	{
		 this.x = x;
		 this.y = y;
		 this.zt = zt;
		 this.rect = new int[]{ 0,0, 28,28 };
		 tuLuJing="images/�ڵ�/�̶�.png";
	}
	
	@Override
	public void run()
	{
		switch (zt) 
		{
		case    ǰ����:
			x+=10;
			break;
		case    ���Ϸ���:
			x+=10;
			y-=3;
			break;
		case    ���·���:
			x+=10;
			y+=3;
			break;
		case    ��ը:
			siLe = true;
			break;
			
		default: 
			break;
		}
	}
	
	@Override
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage( tuLuJing , x, y, g);
	}
	
	@Override
	public void baoZhao(��ͨ��ʬ jiangShi)
	{
		super.baoZhao(jiangShi);
		zt = ��ҩ״̬.��ը;
		tuLuJing="images/�ڵ�/��ը.png";
		jiangShi.beiGongJi();
 
 
	}
}
