
package colin.game.zombie;

import colin.game.core.精灵;

public class 头 extends 精灵
{

	//f
	
	//c
	public 头()
	{
		tuLuJing ="images/僵尸/普通僵尸/头/Frame";
		zongTuShu = 11;
	}
	//m
	@Override
	public void run()
	{
		if (tuHao==zongTuShu) 
		{
			tuLuJing="";
			siLe=true;
		} 
		qieHuanTuPian();
	}

}
