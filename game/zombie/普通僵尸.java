
package colin.game.zombie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import colin.game.core.����;
import colin.game.plant.ֲ��;

public     class ��ͨ��ʬ extends ����
{
	//F
	/**
	 * ��ʬ��
	 */
	protected String name;
	/**
	 * ״̬
	 */
	protected ��ʬ״̬ zt;
	/**
	 * �ȴ� ��ǰ�������
	 */
	protected int fangShi ;
	/**
	 * �ȴ�״̬�µ���ͼ��
	 */
	protected int[] dengDaiZongTuShu ={10,21,10};
	/**
	 * ǰ��״̬����ͼ��
	 */
	protected int[] qianJinZongTuShu ={21,30,17};
	/**
	 * ��ʬǰ���ٶ�
	 */
	protected int qianJinSuDu = 1;
	
	protected ֲ�� zhiWu;
	
	protected ͷ  tou;
	
	//c
	public ��ͨ��ʬ()
	{
		x = (int) (Math.random()*300)+400;
		y = (int) (Math.random()*250+60);
		rect = new int[]{ 62,20,84,122 };
		//�����3��ǰ���͵ȴ���ĳ��
		fangShi =  (int) (Math.random()*3);
		dengDai();
		shengMingZhi = 10;
	}
	public ��ͨ��ʬ(String name)
	{
		this();
		this.name=name;
	}
	
    //M                                                                                                        
	@Override
	public void run()
	{
		switch (zt) 
		{
		case   ǰ��:
		case ��ͷǰ��:
		case ͷ��:
			x-=qianJinSuDu;
			qieHuanTuPian();
			break;
		case �ȴ�:
			qieHuanTuPian();
			break;
		case ����:
			if (zhiWu!=null) 
			{
				if (zhiWu.isSiLe()) 
				{
					zhiWu=null;
					qianJin();
					return ;
				} 
				else
				{
					zhiWu.beiGongJi();
				}
				qieHuanTuPian();
			} 
			break;
		case ��ͷ����:
			qieHuanTuPian();
			break;
		case ������:
			 if ( tou!=null&&tou.isSiLe()  ) //��ͷ��
			{
				wuTouQianJin();
			} 
			else
			{
				qianJin();
			}
			break;
		case ը��:
		case ����:
			if (isZuiHouYiZhangTu()) 
			{
				xiaoShi();
			} 
			else
			{
				qieHuanTuPian();
			}
			
			break;		
		default: 
			break;
		}
		
		if (tou!=null) 
		{
			tou.run();
		} 
		
	}
	
	
	@Override
	public void xianShi(Graphics g)
	{
		super.xianShi(g);
		if (name!=null) 
		{
			g.setColor(Color.RED);
			g.setFont(new Font("����", 0, 20));
			g.drawString(name, x+80, y	);
		} 
		
		if (tou!=null) 
		{
			tou.xianShi(g);
		} 
	}
	/**
	 * �ȴ�
	 */
	public   void dengDai()
	{
		tuHao=0;
		tuLuJing="images/��ʬ/��ͨ��ʬ/�ȴ�"+(fangShi+1)+"/Frame";
		zongTuShu = dengDaiZongTuShu[fangShi];
		zt = ��ʬ״̬.�ȴ�;
	}
	/**
	 * ǰ��
	 */
	public void qianJin()
	{
		tuHao=0;
		tuLuJing="images/��ʬ/��ͨ��ʬ/ǰ��"+(fangShi+1)+"/Frame";
		zongTuShu = qianJinZongTuShu[fangShi];
		zt = ��ʬ״̬.ǰ��;
	}
	/**
	 * ��ͷǰ��
	 */
	public void wuTouQianJin()
	{
		tuHao=0;
		tuLuJing="images/��ʬ/��ͨ��ʬ/��ͷǰ��/Frame";
		zongTuShu = 17;
		zt = ��ʬ״̬.��ͷǰ��;
	}
	/**
	 * ͷ��
	 */
	public void touDiao()
	{
		
		tou = new ͷ();
		tou.setX(x+rect[0]);
		tou.setY(y+rect[1]);
		zt=��ʬ״̬.ͷ��;
	}
	/**
	 * ����
	 * @param zw
	 */
	public void gongJi(ֲ�� zw  )
	{
		if (this.zhiWu!=null) 
		{
			return ;
		} 
		
		this.zhiWu = zw;
		
		tuHao=0;
		tuLuJing="images/��ʬ/��ͨ��ʬ/����/Frame";
		zongTuShu=20;
		zt = ��ʬ״̬.����;
	}
	/**
	 * ��ͷ����
	 * @param zw
	 */
	public void wuTouGongJi(ֲ�� zw)
	{
		this.zhiWu = zw;
		tuHao=0;
		tuLuJing="images/��ʬ/��ͨ��ʬ/��ͷ����/Frame";
		zongTuShu=10;
		zt = ��ʬ״̬.��ͷ����;
	}
	/**
	 * ������
	 */
	public void beiGongJi()
	{
		if (shengMingZhi<=0) 
		{
			return ;
		} 
		shengMingZhi--;
		zt = ��ʬ״̬.������;
		if (shengMingZhi>0&& shengMingZhi<=5) 
		{
			touDiao();
			wuTouQianJin();
		} 
		if (shengMingZhi<=0) 
		{
			 siDiao();
		} 
		 
	 
	}
	/**
	 * ը��
	 */
	public void zhaSi()
	{
		tuHao=0;
		tuLuJing="images/��ʬ/ը��/Frame";
		zongTuShu=19;
	 
		zt = ��ʬ״̬.ը��;
	}
	/**
	 *  ����
	 */
	public void siDiao()
	{
		tuHao=0;
		tuLuJing="images/��ʬ/��ͨ��ʬ/����/Frame";
		zongTuShu=9;
		 
		zt = ��ʬ״̬.����;
	}
	
	/**
	 * ��ʧ
	 * @return
	 */
	public void xiaoShi()
	{
		tuLuJing="";
		siLe = true;
		zt = ��ʬ״̬.��ʧ;
	}
	
	public ��ʬ״̬ getZt()
	{
		return zt;
	}

	public void setZt(��ʬ״̬ zt)
	{
		this.zt = zt;
	}

	public int getFangShi()
	{
		return fangShi;
	}

	public void setFangShi(int fangShi)
	{
		this.fangShi = fangShi;
	}

	public int[] getDengDaiZongTuShu()
	{
		return dengDaiZongTuShu;
	}

	public void setDengDaiZongTuShu(int[] dengDaiZongTuShu)
	{
		this.dengDaiZongTuShu = dengDaiZongTuShu;
	}

	public int[] getQianJinZongTuShu()
	{
		return qianJinZongTuShu;
	}

	public void setQianJinZongTuShu(int[] qianJinZongTuShu)
	{
		this.qianJinZongTuShu = qianJinZongTuShu;
	}

	public ֲ�� getZhiWu()
	{
		return zhiWu;
	}

	public void setZhiWu(ֲ�� zhiWu)
	{
		this.zhiWu = zhiWu;
	}

	public ͷ getTou()
	{
		return tou;
	}

	public void setTou(ͷ tou)
	{
		this.tou = tou;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	 
}
