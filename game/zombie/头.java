
package colin.game.zombie;

import colin.game.core.����;

public class ͷ extends ����
{

	//f
	
	//c
	public ͷ()
	{
		tuLuJing ="images/��ʬ/��ͨ��ʬ/ͷ/Frame";
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
