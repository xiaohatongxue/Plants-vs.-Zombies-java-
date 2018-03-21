
package colin.game.card;

import java.awt.Graphics;
import java.awt.Rectangle;

import colin.game.core.GameFramework;

public class ��Ƭѡ��
{
	//f
	/**
	 * �ܹ���Ҫѡ��ĸ���
	 */
	private int xuanZeGeShu;
	/**
	 * �Ѿ�ѡ��õĸ�ʽ
	 */
	private int yiXuan = 0;
	/**
	 * ��ѡ����
	 */
	private int houXuanGeShu;
	
	
	private ��Ƭѡ��״̬ zt ;
	
	/**
	 * ��ѡ��Ƭ��λ
	 */
	private ��Ƭ[][] ges = new ��Ƭ[5][7];
	/**
	 * ��ѡ�Ŀ�Ƭ
	 */
	private ��Ƭ[]  kas ;
	
	//c
	public ��Ƭѡ��(int xuanZeGeShu,int houXuanGeShu)
	{
		
		this.xuanZeGeShu = xuanZeGeShu;
		
		this.houXuanGeShu = houXuanGeShu;
		
		zt = ��Ƭѡ��״̬.ѡ����;
		
		kas = new ��Ƭ[xuanZeGeShu];
		int ge = 0;

		for (int h = 0; h < 5; h++)
		{
			for (int l = 0; l < 7; l++)
			{
				if (ge>=houXuanGeShu) 
				{		
					return ;
				} 
				ges[h][l] = new ��Ƭ(h, l, ge);
				ge++;
			}
		}
		
	}
	//m
	public void xianShi(Graphics g)
	{
		GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/ֲ��ѡ����.png", 0, 0, g);
		for (int i = 0; i <xuanZeGeShu; i++)
		{
			GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/��Ƭ��.png", 79+51*i+i*10, 8, g);
		}
		////////////////////////////////////////////////
		GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/��Ƭѡ����.png", 0, 90, g);
		
		
		for (int h = 0; h <5; h++)
		{
			for (int l = 0; l < 7; l++)
			{
				GameFramework.drawImage("images/��Ƭ/��Ƭѡ��/��Ƭ��.png", 20+51*l+l*11, 132+72*h+h*11, g);
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
	 * �鿴��������������������
	 */
	public void anWo(int mx,int my)
	{
		//�����ѡ ѡ����
		Rectangle rectYiXuan = new Rectangle(79,6,362,74);
		//�����ѡ��
		Rectangle rectHouXuan = new Rectangle(23,132,422,403);
		//���ҡ��
		Rectangle rectYaoGun = new Rectangle(157,553,154,37);
	
		if (rectYiXuan.contains(mx,my)) 
		{
			quXiaoKaPian(mx, my);
		} 
		else if(rectHouXuan.contains(mx, my))
		{
			//ѡ��Ŀ�Ƭ�����Ѿ��㹻��
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
				zt = ��Ƭѡ��״̬.ѡ�����;
			} 
		}
	}
	/**
	 * ��������λ����ѡ��Ƭ
	 * @param mx
	 * @param my
	 */
	private void xuanZeKaPian(int mx, int my)
	{
		//���������h l
		int l = ((mx - 23)/63);
		int h = (my - 132)/84;
//	System.out.println(h+"  "+l);
		if( ges[h][l]!=null )//�п�Ƭ
		{
			if (ges[h][l].anWo(mx, my)&&ges[h][l].getZt()==��Ƭ״̬.ѡ��ǰ) 
			{
				ges[h][l].setZt(��Ƭ״̬.����ѡ);
				kas[yiXuan] = ges[h][l].copyMe();
				yiXuan++;
			} 
		}
	}
	/**
	 * ȡ����Ƭ
	 * @param mx
	 * @param my
	 */
	private void quXiaoKaPian(int mx, int my)
	{
		int wz = ((mx - 79)/63);
		if( kas[wz].anWo(mx, my) )
		{
			��Ƭ ka = kas[wz];
			ges[ka.getH()][ka.getL()].setZt(��Ƭ״̬.ѡ��ǰ);
			//��Ƭǰ�ƶ�
			for (int xb = wz; xb < yiXuan-1; xb++)
			{
				kas[xb]=kas[xb+1];
			}
			yiXuan--;
		}
	}
	/**
	 * �ܡ�һ��ҡ����
	 * ����ɿ�Ƭѡ�񲢽�����һ����Ϸ����
	 * @return
	 */
	private boolean nengYaoGuanMa()
	{
		//TODO �㷨��û�����տ��򶹰����ܣ������Ǳ�ѡ��
		
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
	public ��Ƭѡ��״̬ getZt()
	{
		return zt;
	}
	public void setZt(��Ƭѡ��״̬ zt)
	{
		this.zt = zt;
	}
	public ��Ƭ[][] getGes()
	{
		return ges;
	}
	public void setGes(��Ƭ[][] ges)
	{
		this.ges = ges;
	}
	public ��Ƭ[] getKas()
	{
		return kas;
	}
	public void setKas(��Ƭ[] kas)
	{
		this.kas = kas;
	}

	
}
