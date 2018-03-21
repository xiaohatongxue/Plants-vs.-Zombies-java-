
package colin.game.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.GameFramework;
import colin.game.plant.植物;
import colin.game.plant.douban.豆瓣;
import colin.game.plant.lj.红辣椒;
import colin.game.plant.xrk.向日葵;

public class 卡片 
{
	//f
	private int x;
	private int y;
	/**
	 * 行
	 */
	private int h;
	/**
	 * 列
	 */
	private int l;
	
	private 卡片状态 zt;
	/**
	 * 卡片种类
	 */
	private  int zhongLei;
	/**
	 * 有效矩形区域
	 */
	private int[] rect = new int[]{ 0,0,50,70 };
	/**
	 * 恢复数
	 */
	private int huiFuShu ;
	
	public 卡片(int h, int l, int zhongLei)
	{
		this.h = h;
		this.l = l;
		this.zhongLei = zhongLei;
		
		x = 20+51*l+l*11;//4列
		y = 132+72*h+h*11;//3行
		//恢复数与卡片的钱数相关
		huiFuShu=money[zhongLei];
		
		zt = 卡片状态.选择前;
	}
	
	static String[] names={"五角星.png","仙人掌.png","冰冻豆瓣.png", 
		"双向豆瓣.png","双头向日葵.png","吃人植物.png","向日葵.png",
		"坚果.png","大瓜.png","机关枪.png","树状豆瓣.png","爆炸草莓.png",
		"玉米.png","豆瓣.png","辣椒.png",
		}; 
	
	static int[] money={100,150,100,
		200,200,10,50,
		50,100,100,200,150,
		200,5,2};
	/**
	 * 植物的类型
	 */
	//TODO 注册卡片对应的植物类型
	static Class[] zhiWuLeiXings = {null,null,null,
		null,null,null,向日葵.class,
		null,null,null,null,null,
		null,豆瓣.class,红辣椒.class};
 
	//c
	
	//m
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/卡片/卡片图/卡片背景.png", x, y, g);
		GameFramework.drawImage("images/卡片/卡片图/"+names[zhongLei], x+5, y+10, g);
 		String value = money[zhongLei]+"";
 		
		g.setColor(Color.black);
		Font f = new Font("Arial Black",Font.PLAIN,12);
		g.setFont(f);
		g.drawString(value,x+8, y+65);
		
		//被选过的效果
		switch (zt) 
		{
		case    不可选:
			Color color = new Color(0, 0, 0, 160);
			g.setColor(color);
			g.fillRect(x, y, rect[2], rect[3]);
			break;
		case 准备中:
			Color colorQian = new Color(0, 0, 0, 100);
			g.setColor(colorQian);
			g.fillRect(x, y, rect[2], rect[3] );
			
			  colorQian = new Color(0, 0, 0, 150);
			g.setColor(colorQian);
			g.fillRect(x, y, rect[2], (int) (rect[3]/1.0/money[zhongLei]*huiFuShu));
			break;
		default: 
			break;
		}
	}
	//m
	
	public void run()
	{
		if (zt == 卡片状态.准备好) 
		{
			return ;
		} 
		 
		if (huiFuShu ==0) 
		{
			huiFuShu=money[zhongLei];
			zt = 卡片状态.准备好;
		} 
		else
		{
			huiFuShu--;
		}
	}
	/**
	 * 得到植物的金额
	 * @return
	 */
	public int getMoneny()
	{
		return money[zhongLei];
	}
	
	public void setZt(卡片状态 zt)
	{
		this.zt = zt;
	}
	/**
	 * 检测鼠标是否点击到
	 * @param mx
	 * @param my
	 * @return
	 */
	public boolean anWo(int mx,int my)
	{
		Rectangle qu = new Rectangle(x,y,rect[2],rect[3]);
		return qu.contains(mx, my);
	}
	/**
	 * 创建植物
	 * @return
	 */
	public 植物 createZhiWu()
	{
		if (zhiWuLeiXings[zhongLei]!=null) 
		{
			try
			{
				//用反射机制创建植物对象
				return (植物) zhiWuLeiXings[zhongLei].newInstance();
			}
			catch (InstantiationException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return null;
	}

	/**
	 * 根据本卡片的属性，复制一个自己返回
	 * TODO 设计模式：用原型模式实现此功能
	 * @return
	 */
	public 卡片 copyMe()
	{
		return new 卡片(h,l,this.zhongLei);
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getH()
	{
		return h;
	}
	public void setH(int h)
	{
		this.h = h;
	}
	public int getL()
	{
		return l;
	}
	public void setL(int l)
	{
		this.l = l;
	}
	public int getZhongLei()
	{
		return zhongLei;
	}
	public void setZhongLei(int zhongLei)
	{
		this.zhongLei = zhongLei;
	}
	public int[] getRect()
	{
		return rect;
	}
	public void setRect(int[] rect)
	{
		this.rect = rect;
	}
	public 卡片状态 getZt()
	{
		return zt;
	}
	
}
