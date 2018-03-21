
package colin.game.zombie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import colin.game.core.精灵;
import colin.game.plant.植物;

public     class 普通僵尸 extends 精灵
{
	//F
	/**
	 * 僵尸名
	 */
	protected String name;
	/**
	 * 状态
	 */
	protected 僵尸状态 zt;
	/**
	 * 等待 或前进的类别
	 */
	protected int fangShi ;
	/**
	 * 等待状态下的总图数
	 */
	protected int[] dengDaiZongTuShu ={10,21,10};
	/**
	 * 前进状态的总图数
	 */
	protected int[] qianJinZongTuShu ={21,30,17};
	/**
	 * 僵尸前进速度
	 */
	protected int qianJinSuDu = 1;
	
	protected 植物 zhiWu;
	
	protected 头  tou;
	
	//c
	public 普通僵尸()
	{
		x = (int) (Math.random()*300)+400;
		y = (int) (Math.random()*250+60);
		rect = new int[]{ 62,20,84,122 };
		//随机出3种前进和等待的某个
		fangShi =  (int) (Math.random()*3);
		dengDai();
		shengMingZhi = 10;
	}
	public 普通僵尸(String name)
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
		case   前进:
		case 无头前进:
		case 头掉:
			x-=qianJinSuDu;
			qieHuanTuPian();
			break;
		case 等待:
			qieHuanTuPian();
			break;
		case 攻击:
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
		case 无头攻击:
			qieHuanTuPian();
			break;
		case 被攻击:
			 if ( tou!=null&&tou.isSiLe()  ) //无头了
			{
				wuTouQianJin();
			} 
			else
			{
				qianJin();
			}
			break;
		case 炸死:
		case 死掉:
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
			g.setFont(new Font("宋体", 0, 20));
			g.drawString(name, x+80, y	);
		} 
		
		if (tou!=null) 
		{
			tou.xianShi(g);
		} 
	}
	/**
	 * 等待
	 */
	public   void dengDai()
	{
		tuHao=0;
		tuLuJing="images/僵尸/普通僵尸/等待"+(fangShi+1)+"/Frame";
		zongTuShu = dengDaiZongTuShu[fangShi];
		zt = 僵尸状态.等待;
	}
	/**
	 * 前进
	 */
	public void qianJin()
	{
		tuHao=0;
		tuLuJing="images/僵尸/普通僵尸/前进"+(fangShi+1)+"/Frame";
		zongTuShu = qianJinZongTuShu[fangShi];
		zt = 僵尸状态.前进;
	}
	/**
	 * 无头前进
	 */
	public void wuTouQianJin()
	{
		tuHao=0;
		tuLuJing="images/僵尸/普通僵尸/无头前进/Frame";
		zongTuShu = 17;
		zt = 僵尸状态.无头前进;
	}
	/**
	 * 头掉
	 */
	public void touDiao()
	{
		
		tou = new 头();
		tou.setX(x+rect[0]);
		tou.setY(y+rect[1]);
		zt=僵尸状态.头掉;
	}
	/**
	 * 攻击
	 * @param zw
	 */
	public void gongJi(植物 zw  )
	{
		if (this.zhiWu!=null) 
		{
			return ;
		} 
		
		this.zhiWu = zw;
		
		tuHao=0;
		tuLuJing="images/僵尸/普通僵尸/攻击/Frame";
		zongTuShu=20;
		zt = 僵尸状态.攻击;
	}
	/**
	 * 无头攻击
	 * @param zw
	 */
	public void wuTouGongJi(植物 zw)
	{
		this.zhiWu = zw;
		tuHao=0;
		tuLuJing="images/僵尸/普通僵尸/无头攻击/Frame";
		zongTuShu=10;
		zt = 僵尸状态.无头攻击;
	}
	/**
	 * 被攻击
	 */
	public void beiGongJi()
	{
		if (shengMingZhi<=0) 
		{
			return ;
		} 
		shengMingZhi--;
		zt = 僵尸状态.被攻击;
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
	 * 炸死
	 */
	public void zhaSi()
	{
		tuHao=0;
		tuLuJing="images/僵尸/炸死/Frame";
		zongTuShu=19;
	 
		zt = 僵尸状态.炸死;
	}
	/**
	 *  死掉
	 */
	public void siDiao()
	{
		tuHao=0;
		tuLuJing="images/僵尸/普通僵尸/死掉/Frame";
		zongTuShu=9;
		 
		zt = 僵尸状态.死掉;
	}
	
	/**
	 * 消失
	 * @return
	 */
	public void xiaoShi()
	{
		tuLuJing="";
		siLe = true;
		zt = 僵尸状态.消失;
	}
	
	public 僵尸状态 getZt()
	{
		return zt;
	}

	public void setZt(僵尸状态 zt)
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

	public 植物 getZhiWu()
	{
		return zhiWu;
	}

	public void setZhiWu(植物 zhiWu)
	{
		this.zhiWu = zhiWu;
	}

	public 头 getTou()
	{
		return tou;
	}

	public void setTou(头 tou)
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
