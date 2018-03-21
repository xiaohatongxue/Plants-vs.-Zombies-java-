
package colin.game.card;

import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.GameFramework;

public class 卡片选区
{
	//f
	/**
	 * 总共需要选择的个数
	 */
	private int xuanZeGeShu;
	/**
	 * 已经选择好的格式
	 */
	private int yiXuan = 0;
	/**
	 * 被选个数
	 */
	private int houXuanGeShu;
	
	
	private 卡片选区状态 zt ;
	
	/**
	 * 候选卡片空位
	 */
	private 卡片[][] ges = new 卡片[5][7];
	/**
	 * 已选的卡片
	 */
	private 卡片[]  kas ;
	
	//c
	public 卡片选区(int xuanZeGeShu,int houXuanGeShu)
	{
		
		this.xuanZeGeShu = xuanZeGeShu;
		
		this.houXuanGeShu = houXuanGeShu;
		
		zt = 卡片选区状态.选择中;
		
		kas = new 卡片[xuanZeGeShu];
		int ge = 0;

		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 7; l++)
			{
				if (ge>=houXuanGeShu) 
				{		
					return ;
				} 
				ges[h][l] = new 卡片(h, l, ge);
				ge++;
			}
		}
		
	}
	//m
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/卡片/卡片选择/植物选择区.png", 0, 0, g);
		for (int i = 0; i <xuanZeGeShu; i++)
		{
			GameFramework.drawImage("images/卡片/卡片选择/卡片区.png", 79+51*i+i*10, 8, g);
		}
		////////////////////////////////////////////////
		GameFramework.drawImage("images/卡片/卡片选择/卡片选择区.png", 0, 90, g);
		
		
		for (int h = 0; h <5; h++)
		{
			for (int l = 0; l < 7; l++)
			{
				GameFramework.drawImage("images/卡片/卡片选择/卡片区.png", 20+51*l+l*11, 132+72*h+h*11, g);
				if (ges[h][l]!=null) 
				{
					ges[h][l].xianShi(g);
				} 
			}
		}
		
		for (int xb = 0; xb <yiXuan; xb++)
		{
			kas[xb].setX(79+xb*62)  ;
			kas[xb].setY( 6 );
			kas[xb].xianShi(g);
		}
	}
	/**
	 * 查看被点击的区域来决定如何
	 */
	public void anWo(int mx,int my)
	{
		//点击已选 选择区
		Rectangle rectYiXuan = new Rectangle(79,6,362,74);
		//点击候选区
		Rectangle rectHouXuan = new Rectangle(23,132,422,403);
		//点击摇滚
		Rectangle rectYaoGun = new Rectangle(157,553,154,37);
	
		if (rectYiXuan.contains(mx,my)) 
		{
			quXiaoKaPian(mx, my);
		} 
		else if(rectHouXuan.contains(mx, my))
		{
			//选择的卡片总数已经足够了
			if (xuanZeGeShu==yiXuan) 
			{
				return ;
			} 
			xuanZeKaPian(mx, my);
		}
		else if(rectYaoGun.contains(mx, my))
		{
			if (nengYaoGuanMa()) 
			{
				zt = 卡片选区状态.选择完成;
			} 
		}
	}
	/**
	 * 根据鼠标的位置来选择卡片
	 * @param mx
	 * @param my
	 */
	private void xuanZeKaPian(int mx, int my)
	{
		//根据鼠标获得h l
		int l = ((mx - 23)/63);
		int h = (my - 132)/84;
//	System.out.println(h+"  "+l);
		if( ges[h][l]!=null )//有卡片
		{
			if (ges[h][l].anWo(mx, my)&&ges[h][l].getZt()==卡片状态.选择前) 
			{
				ges[h][l].setZt(卡片状态.不可选);
				kas[yiXuan] = ges[h][l].copyMe();
				yiXuan++;
			} 
		}
	}
	/**
	 * 取消卡片
	 * @param mx
	 * @param my
	 */
	private void quXiaoKaPian(int mx, int my)
	{
		int wz = ((mx - 79)/63);
		if( kas[wz].anWo(mx, my) )
		{
			卡片 ka = kas[wz];
			ges[ka.getH()][ka.getL()].setZt(卡片状态.选择前);
			//卡片前移动
			for (int xb = wz; xb < yiXuan-1; xb++)
			{
				kas[xb]=kas[xb+1];
			}
			yiXuan--;
		}
	}
	/**
	 * 能“一起摇滚吗”
	 * 能完成卡片选择并进入下一个游戏环节
	 * @return
	 */
	private boolean nengYaoGuanMa()
	{
		//TODO 算法：没有向日葵或豆瓣则不能，他俩是必选项
		
		return xuanZeGeShu==yiXuan;
	}
	
	
	public int getXuanZeGeShu()
	{
		return xuanZeGeShu;
	}
	public void setXuanZeGeShu(int xuanZeGeShu)
	{
		this.xuanZeGeShu = xuanZeGeShu;
	}
	public int getYiXuan()
	{
		return yiXuan;
	}
	public void setYiXuan(int yiXuan)
	{
		this.yiXuan = yiXuan;
	}
	public int getHouXuanGeShu()
	{
		return houXuanGeShu;
	}
	public void setHouXuanGeShu(int houXuanGeShu)
	{
		this.houXuanGeShu = houXuanGeShu;
	}
	public 卡片选区状态 getZt()
	{
		return zt;
	}
	public void setZt(卡片选区状态 zt)
	{
		this.zt = zt;
	}
	public 卡片[][] getGes()
	{
		return ges;
	}
	public void setGes(卡片[][] ges)
	{
		this.ges = ges;
	}
	public 卡片[] getKas()
	{
		return kas;
	}
	public void setKas(卡片[] kas)
	{
		this.kas = kas;
	}

	
}
