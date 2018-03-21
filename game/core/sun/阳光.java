
package colin.game.core.sun;

import java.awt.Graphics;

import colin.game.core.精灵;

public class 阳光 extends 精灵
{
	//f
	/**
	 * 下落到x
	 */
	private int muBiaoX;
	/**
	 * 下落到y
	 */
	private int muBiaoY;
	
	private 阳光状态 zt = 阳光状态.下落;
	//c
	public 阳光()
	{
		rect=new int[]{ 0,0,78,78 };
		tuLuJing="images/阳光/Frame";
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
		case    下落:
			y+=4;
			if (y>muBiaoY) 
			{
				zt=阳光状态.到位;
			} 
			break;
		case    到位:
			break;
		case    捡起:
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
	 * 检测鼠标按
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
	 * 捡起来
	 */
	public boolean jianQiLai()
	{
		if (zt != 阳光状态.捡起) 
		{
			zt = 阳光状态.捡起;
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
	public 阳光状态 getZt()
	{
		return zt;
	}
	public void setZt(阳光状态 zt)
	{
		this.zt = zt;
	}
}
