
package colin.game.plant.xrk;

import colin.game.core.sun.����;
import colin.game.plant.ֲ��;

public class ���տ� extends ֲ��
{
	private ���� yg;
	private int jianGe = 20;
	public ���տ�()
	{
		tuLuJing="images/��Ƭ/׼����ֲ/���տ�.png";
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
			yg = new ����();
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
		tuLuJing="images/ֲ��/���տ�/SunFlower/Frame";
		zongTuShu=17;
	}

	public ���� getYg()
	{
		���� lin = yg;
		yg = null;
		return lin;
	}

	public void setYg(���� yg)
	{
		this.yg = yg;
	}
}
