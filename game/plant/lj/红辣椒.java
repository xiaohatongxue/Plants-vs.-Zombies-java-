
package colin.game.plant.lj;

import java.awt.Graphics;

import colin.game.core.GameFramework;
import colin.game.plant.ֲ��;
import colin.game.plant.ֲ��״̬;

public class ������ extends ֲ��
{
	int hang;
	public ������()
	{
		tuLuJing="images/��Ƭ/׼����ֲ/����.png";
		rect=new int[]{0,0,60,70};
		shengMingZhi = 10;
	}
	@Override
	public void zhongHao()
	{
		tuHao=0;
		tuLuJing="images/ֲ��/����/Jalapeno/Frame";
		zongTuShu=7;
		zt = ֲ��״̬.�ֺ�;
	}
 
	public void fangHuo()
	{
		tuHao=0;
		tuLuJing="images/ֲ��/����/JalapenoAttack/Frame";
		zongTuShu=7;
		hang=	  (y-73) /100 ;
		zt=ֲ��״̬.�Ż�;
	}
	
	@Override
	public void run()
	{
		super.run();
		switch (zt) 
		{
		case �ֺ�:
			if (isZuiHouYiZhangTu()) 
			{
				fangHuo();
			} 
			break;
		case    �Ż�:
			if (isZuiHouYiZhangTu()) 
			{
				siLe=true;
			} 
			else
			{
				qieHuanTuPian();
			}
			break;
		default: 
			break;
		}
	}
	
	@Override
	public void xianShi(Graphics g)
	{
		super.xianShi(g);
		switch (zt) 
		{
		case    �Ż�:
			//y = hang*100+73;
			GameFramework.drawImage( tuLuJing+tuHao+".png", 45, hang*100+50, g);
			break;
		default: 
			break;
		}
	}
	public int getHang()
	{
		return hang;
	}
	public void setHang(int hang)
	{
		this.hang = hang;
	}
	
}
