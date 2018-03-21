
package colin.game.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.GameFramework;
import colin.game.plant.ֲ��;

public class ֲ��ѡ����
{
	// f
	/**
	 * ���еĿ�Ƭ
	 */
	private ��Ƭ[]	kas;
	/**
	 * �����Ǯ��
	 */
	private int	yangGuangShuLiang = 9999;
	
	/**
	 * ��¼ֲ�ﱻ��ֲ�ļ۸�
	 * ���ȡ����ֲ����۸�ԭ
	 */
	private int jiaGe;

	// c
	public ֲ��ѡ����(��Ƭ[] kas)
	{
		this.kas = kas;
		for (int xb = 0; xb <kas.length; xb++)
		{
			kas[xb].setX(79+xb*62)  ;
			kas[xb].setY( 6 );
			kas[xb].setZt(��Ƭ״̬.׼����);
		}
	}
	
	/**
	 * ѡ��Ƭ
	 * @param mx
	 * @param my
	 * @return ��Ƭ��Ӧ��ֲ��
	 */
	public ֲ�� xuanZeKaPian(int mx,int my)
	{
		//�����ѡ ѡ����
		Rectangle rectYiXuan = new Rectangle(79,6,362,74);
		if ( rectYiXuan.contains(mx,my) ) 
		{
			int wz = ((mx - 79)/63);
			if( kas[wz].anWo(mx, my) )
			{
				��Ƭ ka = kas[wz];
				if ( ka.getZt()==��Ƭ״̬.׼����&& yangGuangShuLiang>=ka.getMoneny() ) 
				{
					jiaGe = ka.getMoneny();
					jianShao();
					ka.setZt(��Ƭ״̬.׼����);
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
	 * ��ʾ
	 * @param g
	 */
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/ֲ��ѡ����.png", 0, 0, g);
		for (int i = 0; i < kas.length; i++)
		{
			GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/��Ƭ��.png", 79 + 51 * i + i
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

	public ��Ƭ[] getKas()
	{
		return kas;
	}

	public void setKas(��Ƭ[] kas)
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
