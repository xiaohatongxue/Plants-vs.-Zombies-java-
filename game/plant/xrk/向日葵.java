
package colin.game.plant.xrk;

import colin.game.core.sun.阳光;
import colin.game.plant.植物;

public class 向日葵 extends 植物
{
	private 阳光 yg;
	private int jianGe = 20;
	public 向日葵()
	{
		tuLuJing="images/卡片/准备种植/向日葵.png";
		rect=new int[]{0,0,60,70};
		shengMingZhi = 30;
	}
	@Override
	public void run()
	{
		super.run();
		if (jianGe==0) 
		{
			jianGe =50;
			yg = new 阳光();
			yg.setX(x);
			yg.setY(y);
			yg.setMuBiaoX(x+60);
			yg.setMuBiaoY(y+60);
		} 
		else
		{
			jianGe--;
		}
	}
	@Override
	public void zhongHao()
	{
		tuHao=0;
		tuLuJing="images/植物/向日葵/SunFlower/Frame";
		zongTuShu=17;
	}

	public 阳光 getYg()
	{
		阳光 lin = yg;
		yg = null;
		return lin;
	}

	public void setYg(阳光 yg)
	{
		this.yg = yg;
	}
}
