
package colin.game.plant;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.core.GameFramework;
import colin.game.core.����;
import colin.game.plant.wuqi.��ҩ;

public abstract class ֲ�� extends ����
{
	//f
    protected ArrayList<��ҩ> listDanYao= new ArrayList<��ҩ>();
	protected ֲ��״̬  zt;
	//c
	public ֲ��()
	{
		zt = ֲ��״̬.׼����ֲ;
	}
	//m
	/**
	 * ������
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
	
	public ֲ��״̬ getZt()
	{
		return zt;
	}
	public void setZt(ֲ��״̬ zt)
	{
		this.zt = zt;
		switch (zt) 
		{
		case    �ֺ�:
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
		case    ׼����ֲ:
			break;
		case    �ֺ�:
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
		case    ׼����ֲ:
			GameFramework.drawImage( tuLuJing, x, y, g);
			break;
		case    �ֺ�:
			super.xianShi(g);	
			break;
		default: 
			break;
		}
		
	}
	
	public ArrayList<��ҩ> getListDanYao()
	{
		ArrayList<��ҩ> cloneList = (ArrayList<��ҩ>) listDanYao.clone();
		listDanYao.clear();
		return cloneList;
	}

	public void setListDanYao(ArrayList<��ҩ> listDanYao)
	{
		this.listDanYao = listDanYao;
	}
}
