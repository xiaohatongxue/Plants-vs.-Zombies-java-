
package colin.game.core;

import java.awt.Graphics;
import java.awt.Rectangle;


public  abstract  class 精灵  
{
	//F
	/**
	 * 显示的x坐标
	 */
	protected int	x;
	/**
	 * 显示的y坐标
	 */
	protected int	y;
	/**
	 * 当前图片号
	 */
	protected  int	tuHao;
	/**
	 * 图路径
	 */
	protected String	tuLuJing;
	/**
	 * 总图数
	 */
	protected int	zongTuShu;
	/**
	 * 死掉了吗
	 */
	protected boolean	siLe	= false;
	/**
	 * 有效矩形区域
	 */
	protected int[]	rect	= null;
	/**
	 * 生命值
	 */
	protected int shengMingZhi;
	
	//C
	public 精灵()
	{
		super();
	}
	//M
	/**
	 * 显示
	 * @param g
	 */
	public   void xianShi(Graphics g)
	{
		GameFramework.drawImage( tuLuJing+tuHao+".png", x, y, g);
	}

	/**
	 * 动<br>
	 * 图片切换 形成动画
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
	 * 是最后一张图
	 */
	public boolean isZuiHouYiZhangTu()
	{
		return tuHao==zongTuShu;
	}

	/**
	 * 运行
	 * 精灵如何运动
	 */
	public abstract void run();
	

	/**
	 * 获取精灵有效的矩形区
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
