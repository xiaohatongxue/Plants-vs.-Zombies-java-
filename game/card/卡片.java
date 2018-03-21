
package colin.game.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.GameFramework;
import colin.game.plant.ֲ��;
import colin.game.plant.douban.����;
import colin.game.plant.lj.������;
import colin.game.plant.xrk.���տ�;

public class ��Ƭ 
{
	//f
	private int x;
	private int y;
	/**
	 * ��
	 */
	private int h;
	/**
	 * ��
	 */
	private int l;
	
	private ��Ƭ״̬ zt;
	/**
	 * ��Ƭ����
	 */
	private  int zhongLei;
	/**
	 * ��Ч��������
	 */
	private int[] rect = new int[]{ 0,0,50,70 };
	/**
	 * �ָ���
	 */
	private int huiFuShu ;
	
	public ��Ƭ(int h, int l, int zhongLei)
	{
		this.h = h;
		this.l = l;
		this.zhongLei = zhongLei;
		
		x = 20+51*l+l*11;//4��
		y = 132+72*h+h*11;//3��
		//�ָ����뿨Ƭ��Ǯ�����
		huiFuShu=money[zhongLei];
		
		zt = ��Ƭ״̬.ѡ��ǰ;
	}
	
	static String[] names={"�����.png","������.png","��������.png", 
		"˫�򶹰�.png","˫ͷ���տ�.png","����ֲ��.png","���տ�.png",
		"���.png","���.png","����ǹ.png","��״����.png","��ը��ݮ.png",
		"����.png","����.png","����.png",
		}; 
	
	static int[] money={100,150,100,
		200,200,10,50,
		50,100,100,200,150,
		200,5,2};
	/**
	 * ֲ�������
	 */
	//TODO ע�ῨƬ��Ӧ��ֲ������
	static Class[] zhiWuLeiXings = {null,null,null,
		null,null,null,���տ�.class,
		null,null,null,null,null,
		null,����.class,������.class};
 
	//c
	
	//m
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/��Ƭ/��Ƭͼ/��Ƭ����.png", x, y, g);
		GameFramework.drawImage("images/��Ƭ/��Ƭͼ/"+names[zhongLei], x+5, y+10, g);
 		String value = money[zhongLei]+"";
 		
		g.setColor(Color.black);
		Font f = new Font("Arial Black",Font.PLAIN,12);
		g.setFont(f);
		g.drawString(value,x+8, y+65);
		
		//��ѡ����Ч��
		switch (zt) 
		{
		case    ����ѡ:
			Color color = new Color(0, 0, 0, 160);
			g.setColor(color);
			g.fillRect(x, y, rect[2], rect[3]);
			break;
		case ׼����:
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
		if (zt == ��Ƭ״̬.׼����) 
		{
			return ;
		} 
		 
		if (huiFuShu ==0) 
		{
			huiFuShu=money[zhongLei];
			zt = ��Ƭ״̬.׼����;
		} 
		else
		{
			huiFuShu--;
		}
	}
	/**
	 * �õ�ֲ��Ľ��
	 * @return
	 */
	public int getMoneny()
	{
		return money[zhongLei];
	}
	
	public void setZt(��Ƭ״̬ zt)
	{
		this.zt = zt;
	}
	/**
	 * �������Ƿ�����
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
	 * ����ֲ��
	 * @return
	 */
	public ֲ�� createZhiWu()
	{
		if (zhiWuLeiXings[zhongLei]!=null) 
		{
			try
			{
				//�÷�����ƴ���ֲ�����
				return (ֲ��) zhiWuLeiXings[zhongLei].newInstance();
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
	 * ���ݱ���Ƭ�����ԣ�����һ���Լ�����
	 * TODO ���ģʽ����ԭ��ģʽʵ�ִ˹���
	 * @return
	 */
	public ��Ƭ copyMe()
	{
		return new ��Ƭ(h,l,this.zhongLei);
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
	public ��Ƭ״̬ getZt()
	{
		return zt;
	}
	
}
