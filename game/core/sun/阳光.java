
package colin.game.core.sun;

import java.awt.Graphics;

import colin.game.core.����;

public class ���� extends ����
{
	//f
	/**
	 * ���䵽x
	 */
	private int muBiaoX;
	/**
	 * ���䵽y
	 */
	private int muBiaoY;
	
	private ����״̬ zt = ����״̬.����;
	//c
	public ����()
	{
		rect=new int[]{ 0,0,78,78 };
		tuLuJing="images/����/Frame";
		zongTuShu=21;
		x=(int) (Math.random()*300)+400;
		muBiaoX=x;
		y=10;
		muBiaoY = (int) (Math.random()*200)+200;
		shengMingZhi=200;
	}
	//m
	@Override
	public void run()
	{
		if (shengMingZhi==0) 
		{
			siLe=true;
			return ;
		} 
		shengMingZhi--;
		qieHuanTuPian();
		switch (zt) 
		{
		case    ����:
			y+=4;
			if (y>muBiaoY) 
			{
				zt=����״̬.��λ;
			} 
			break;
		case    ��λ:
			break;
		case    ����:
			if (x==muBiaoX) 
			{
				siLe=true;
				tuLuJing="";
			}
			else
			{
				x-=10;
				y-=10;
			}
			break;	
		default: 
			break;
		}
	}
	/**
	 * �����갴
	 * @return
	 */
	public boolean anWo(int mx,int my)
	{
		if (siLe) 
		{
			return false;
		} 
		if (getRect().contains(mx, my)) 
		{
			return jianQiLai();
		} 
		return false;
	}
	/**
	 * ������
	 */
	public boolean jianQiLai()
	{
		if (zt != ����״̬.����) 
		{
			zt = ����״̬.����;
			x=60;
			y=60;
			muBiaoX=10;
			muBiaoY=10;
			return true;
		} 
		return false;
	}
	
	@Override
	public void xianShi(Graphics g)
	{
		if (siLe==false) 
		{
			super.xianShi(g);
		} 
	}
	
	
	public int getMuBiaoX()
	{
		return muBiaoX;
	}
	public void setMuBiaoX(int muBiaoX)
	{
		this.muBiaoX = muBiaoX;
	}
	public int getMuBiaoY()
	{
		return muBiaoY;
	}
	public void setMuBiaoY(int muBiaoY)
	{
		this.muBiaoY = muBiaoY;
	}
	public ����״̬ getZt()
	{
		return zt;
	}
	public void setZt(����״̬ zt)
	{
		this.zt = zt;
	}
}
