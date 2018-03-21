
package colin.game.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.GameFramework;
import colin.game.plant.植物;

public class 植物选择区
{
	// f
	/**
	 * 所有的卡片
	 */
	private 卡片[]	kas;
	/**
	 * 阳光的钱数
	 */
	private int	yangGuangShuLiang = 9999;
	
	/**
	 * 记录植物被种植的价格；
	 * 如果取消种植，则价格还原
	 */
	private int jiaGe;

	// c
	public 植物选择区(卡片[] kas)
	{
		this.kas = kas;
		for (int xb = 0; xb <kas.length; xb++)
		{
			kas[xb].setX(79+xb*62)  ;
			kas[xb].setY( 6 );
			kas[xb].setZt(卡片状态.准备中);
		}
	}
	
	/**
	 * 选择卡片
	 * @param mx
	 * @param my
	 * @return 卡片对应的植物
	 */
	public 植物 xuanZeKaPian(int mx,int my)
	{
		//点击已选 选择区
		Rectangle rectYiXuan = new Rectangle(79,6,362,74);
		if ( rectYiXuan.contains(mx,my) ) 
		{
			int wz = ((mx - 79)/63);
			if( kas[wz].anWo(mx, my) )
			{
				卡片 ka = kas[wz];
				if ( ka.getZt()==卡片状态.准备好&& yangGuangShuLiang>=ka.getMoneny() ) 
				{
					jiaGe = ka.getMoneny();
					jianShao();
					ka.setZt(卡片状态.准备中);
					return ka.createZhiWu();
				} 
				else
				{
					return null;
				}
			}
		}
		return null; 
	}

	// m
	/**
	 * 显示
	 * @param g
	 */
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/卡片/卡片选择/植物选择区.png", 0, 0, g);
		for (int i = 0; i < kas.length; i++)
		{
			GameFramework.drawImage("images/卡片/卡片选择/卡片区.png", 79 + 51 * i + i
					* 10, 8, g);
		}
		for (int xb = 0; xb < kas.length; xb++)
		{
			kas[xb].xianShi(g);
		}
		g.setColor(Color.black);
		Font f = new Font("Arial Black", Font.PLAIN, 12);
		g.setFont(f);
		g.drawString(yangGuangShuLiang + "", 23, 74);
	}
	
	public void run()
	{
		for (int xb = 0; xb < kas.length; xb++)
		{
			kas[xb].run();
		}
	}

	public 卡片[] getKas()
	{
		return kas;
	}

	public void setKas(卡片[] kas)
	{
		this.kas = kas;
	}

	public void zengJia(int value)
	{
		this.yangGuangShuLiang+=value;
	}
	
	public void jianShao()
	{
		this.yangGuangShuLiang-=jiaGe;
	}
	
	public void huanYuan()
	{
		zengJia(jiaGe);
		jiaGe = 0;
	}
	
	public int getYangGuangShuLiang()
	{
		return yangGuangShuLiang;
	}
}
