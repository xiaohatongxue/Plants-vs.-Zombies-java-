
package colin.game.plant.lj;

import java.awt.Graphics;

import colin.game.core.GameFramework;
import colin.game.plant.植物;
import colin.game.plant.植物状态;

public class 红辣椒 extends 植物
{
	int hang;
	public 红辣椒()
	{
		tuLuJing="images/卡片/准备种植/辣椒.png";
		rect=new int[]{0,0,60,70};
		shengMingZhi = 10;
	}
	@Override
	public void zhongHao()
	{
		tuHao=0;
		tuLuJing="images/植物/辣椒/Jalapeno/Frame";
		zongTuShu=7;
		zt = 植物状态.种好;
	}
 
	public void fangHuo()
	{
		tuHao=0;
		tuLuJing="images/植物/辣椒/JalapenoAttack/Frame";
		zongTuShu=7;
		hang=	  (y-73) /100 ;
		zt=植物状态.放火;
	}
	
	@Override
	public void run()
	{
		super.run();
		switch (zt) 
		{
		case 种好:
			if (isZuiHouYiZhangTu()) 
			{
				fangHuo();
			} 
			break;
		case    放火:
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
		case    放火:
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
