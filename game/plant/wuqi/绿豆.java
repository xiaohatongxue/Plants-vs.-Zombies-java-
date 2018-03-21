

package colin.game.plant.wuqi;

import java.awt.Graphics;

import colin.game.core.GameFramework;
import colin.game.zombie.ÆÕÍ¨½©Ê¬;

public class ÂÌ¶¹ extends µ¯Ò©
{

	public ÂÌ¶¹( int x,int y,µ¯Ò©×´Ì¬ zt )
	{
		 this.x = x;
		 this.y = y;
		 this.zt = zt;
		 this.rect = new int[]{ 0,0, 28,28 };
		 tuLuJing="images/ÅÚµ¯/ÂÌ¶¹.png";
	}
	
	@Override
	public void run()
	{
		switch (zt) 
		{
		case    Ç°·ÉÐÐ:
			x+=10;
			break;
		case    ÓÒÉÏ·ÉÐÐ:
			x+=10;
			y-=3;
			break;
		case    ÓÒÏÂ·ÉÐÐ:
			x+=10;
			y+=3;
			break;
		case    ±¬Õ¨:
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
	public void baoZhao(ÆÕÍ¨½©Ê¬ jiangShi)
	{
		super.baoZhao(jiangShi);
		zt = µ¯Ò©×´Ì¬.±¬Õ¨;
		tuLuJing="images/ÅÚµ¯/±¬Õ¨.png";
		jiangShi.beiGongJi();
 
 
	}
}
