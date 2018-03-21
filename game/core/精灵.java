
package colin.game.core;

import java.awt.Graphics;
import java.awt.Rectangle;


public  abstract  class ����  
{
	//F
	/**
	 * ��ʾ��x����
	 */
	protected int	x;
	/**
	 * ��ʾ��y����
	 */
	protected int	y;
	/**
	 * ��ǰͼƬ��
	 */
	protected  int	tuHao;
	/**
	 * ͼ·��
	 */
	protected String	tuLuJing;
	/**
	 * ��ͼ��
	 */
	protected int	zongTuShu;
	/**
	 * ��������
	 */
	protected boolean	siLe	= false;
	/**
	 * ��Ч��������
	 */
	protected int[]	rect	= null;
	/**
	 * ����ֵ
	 */
	protected int shengMingZhi;
	
	//C
	public ����()
	{
		super();
	}
	//M
	/**
	 * ��ʾ
	 * @param g
	 */
	public   void xianShi(Graphics g)
	{
		GameFramework.drawImage( tuLuJing+tuHao+".png", x, y, g);
	}

	/**
	 * ��<br>
	 * ͼƬ�л� �γɶ���
	 */
	public void qieHuanTuPian()
	{
		if (isZuiHouYiZhangTu()) 
		{
			tuHao = 0;
		} 
		else
		{
			tuHao++;
		}
	}
	/**
	 * �����һ��ͼ
	 */
	public boolean isZuiHouYiZhangTu()
	{
		return tuHao==zongTuShu;
	}

	/**
	 * ����
	 * ��������˶�
	 */
	public abstract void run();
	

	/**
	 * ��ȡ������Ч�ľ�����
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle(x+rect[0], y+rect[1], rect[2], rect[3]);
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
	public int getTuHao()
	{
		return tuHao;
	}
	public void setTuHao(int tuHao)
	{
		this.tuHao = tuHao;
	}
	public String getTuLuJing()
	{
		return tuLuJing;
	}
	public void setTuLuJing(String tuLuJing)
	{
		this.tuLuJing = tuLuJing;
	}
	public int getZongTuShu()
	{
		return zongTuShu;
	}
	public void setZongTuShu(int zongTuShu)
	{
		this.zongTuShu = zongTuShu;
	}
	public boolean isSiLe()
	{
		return siLe;
	}
	public void setSiLe(boolean siLe)
	{
		this.siLe = siLe;
	}
	public void setRect(int[] rect)
	{
		this.rect = rect;
	}
	public int getShengMingZhi()
	{
		return shengMingZhi;
	}
	public void setShengMingZhi(int shengMingZhi)
	{
		this.shengMingZhi = shengMingZhi;
	}
	

}
