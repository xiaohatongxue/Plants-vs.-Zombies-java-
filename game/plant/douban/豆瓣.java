

package colin.game.plant.douban;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.core.GameFramework;
import colin.game.plant.ֲ��;
import colin.game.plant.ֲ��״̬;
import colin.game.plant.wuqi.��ҩ״̬;
import colin.game.plant.wuqi.�̶�;

public class ���� extends ֲ��
{

	//field����
	
	
	//constructor������
	public ����()
	{
		tuLuJing="images/��Ƭ/׼����ֲ/����.png";
		rect=new int[]{0,0,70,80};
		shengMingZhi = 20;
	}
	//method����
	@Override
	public void zhongHao()
	{
		tuHao=0;
		tuLuJing="images/ֲ��/����/Peashooter/Frame";
		zongTuShu=12;
		zt = ֲ��״̬.�ֺ�;
	}
	
	@Override
	public void run()
	{
		super.run();
		switch (zt) 
		{
		case    �����ڵ�:
			qieHuanTuPian();
			if ( tuHao==3 ) 
			{
				�̶� ld = new �̶�(x+62, y+2, ��ҩ״̬.ǰ����);
				listDanYao.add(ld);
//				ld = new �̶�(x+62, y+2, ��ҩ״̬.���Ϸ���);
//				listDanYao.add(ld);
//				ld = new �̶�(x+62, y+2, ��ҩ״̬.���·���);
//				listDanYao.add(ld);
			} 
			break;
		default: 
			break;
		}
	}
	
	@Override
	public void xianShi(Graphics g)
	{
		super.xianShi(g);
		switch (zt) 
		{
		case    �����ڵ�:
			GameFramework.drawImage( tuLuJing+tuHao+".png", x, y, g);
			break;
		default: 
			break;
		}
	}
	
	public void faShePaoDan()
	{
		zt = ֲ��״̬.�����ڵ�;
	}
	
	
}
