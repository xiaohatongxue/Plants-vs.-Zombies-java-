
package colin.game.core.dikuai;

import java.awt.Color;
import java.awt.Graphics;

import colin.game.core.GameFramework;
import colin.game.plant.植物;

public class 地块  
{
	//f
	/**
	 * 关联植物
	 */
	private 植物 zw;
	
	private int hang;
	
	private int lie;
	
	private int x;
	

	private int y;
	//c
	public 地块(int hang, int lie)
	{
		super();
		this.hang = hang;
		this.lie = lie;
		 x = lie*82+45;
		 y = hang*100+73;
	}
	//m
	
	public void run()
	{
		if (zw!=null   ) 
		{
			if ( zw.isSiLe() ) 
			{
				zw = null;
			} 
			else
			{
				zw.run();
			}
		} 
	}
	
	public void xianShi( Graphics g)
	{
		if (zw!=null ) 
		{
			GameFramework.drawImage("images/interface/plantshadow32.png", x, (int)(y+zw.getRect().getHeight())-25, g);
			zw.xianShi(g);
			
		} 
//		g.setColor(Color.red);
//		g.drawRect(x, y, 80, 100);
	}

	public 植物 getZhiWu()
	{
		return zw;
	}
	public void setZw(植物 zw)
	{
		this.zw = zw;
		if (zw==null) 
		{
			return;
		} 
		zw.setX(x);
		zw.setY(y);
	}
}
