
package colin.game.plant;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.core.GameFramework;
import colin.game.core.精灵;
import colin.game.plant.wuqi.弹药;

public abstract class 植物 extends 精灵
{
	//f
    protected ArrayList<弹药> listDanYao= new ArrayList<弹药>();
	protected 植物状态  zt;
	//c
	public 植物()
	{
		zt = 植物状态.准备种植;
	}
	//m
	/**
	 * 被攻击
	 */
	public void beiGongJi()
	{
		if ( shengMingZhi==0 ) 
		{
			siLe=true;
		} 
		else
		{
			shengMingZhi--;
		}
		
		
	}
	
	public 植物状态 getZt()
	{
		return zt;
	}
	public void setZt(植物状态 zt)
	{
		this.zt = zt;
		switch (zt) 
		{
		case    种好:
			zhongHao();
			break;
		default: 
			break;
		}
	}

	public abstract void zhongHao();
	
	@Override
	public void run()
	{
		switch (zt) 
		{
		case    准备种植:
			break;
		case    种好:
			qieHuanTuPian();
			break;
		default: 
			break;
		}
	}
	
	@Override
	public void xianShi(Graphics g)
	{
		switch (zt) 
		{
		case    准备种植:
			GameFramework.drawImage( tuLuJing, x, y, g);
			break;
		case    种好:
			super.xianShi(g);	
			break;
		default: 
			break;
		}
		
	}
	
	public ArrayList<弹药> getListDanYao()
	{
		ArrayList<弹药> cloneList = (ArrayList<弹药>) listDanYao.clone();
		listDanYao.clear();
		return cloneList;
	}

	public void setListDanYao(ArrayList<弹药> listDanYao)
	{
		this.listDanYao = listDanYao;
	}
}
