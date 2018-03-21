

package colin.game.plant.douban;

import java.awt.Graphics;
import java.util.ArrayList;

import colin.game.core.GameFramework;
import colin.game.plant.Ö²Îï;
import colin.game.plant.Ö²Îï×´Ì¬;
import colin.game.plant.wuqi.µ¯Ò©×´Ì¬;
import colin.game.plant.wuqi.ÂÌ¶¹;

public class ¶¹°ê extends Ö²Îï
{

	//fieldÊôĞÔ
	
	
	//constructor¹¹ÔìÆ÷
	public ¶¹°ê()
	{
		tuLuJing="images/¿¨Æ¬/×¼±¸ÖÖÖ²/¶¹°ê.png";
		rect=new int[]{0,0,70,80};
		shengMingZhi = 20;
	}
	//method·½·¨
	@Override
	public void zhongHao()
	{
		tuHao=0;
		tuLuJing="images/Ö²Îï/¶¹°ê/Peashooter/Frame";
		zongTuShu=12;
		zt = Ö²Îï×´Ì¬.ÖÖºÃ;
	}
	
	@Override
	public void run()
	{
		super.run();
		switch (zt) 
		{
		case    ·¢ÉäÅÚµ¯:
			qieHuanTuPian();
			if ( tuHao==3 ) 
			{
				ÂÌ¶¹ ld = new ÂÌ¶¹(x+62, y+2, µ¯Ò©×´Ì¬.Ç°·ÉĞĞ);
				listDanYao.add(ld);
//				ld = new ÂÌ¶¹(x+62, y+2, µ¯Ò©×´Ì¬.ÓÒÉÏ·ÉĞĞ);
//				listDanYao.add(ld);
//				ld = new ÂÌ¶¹(x+62, y+2, µ¯Ò©×´Ì¬.ÓÒÏÂ·ÉĞĞ);
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
		case    ·¢ÉäÅÚµ¯:
			GameFramework.drawImage( tuLuJing+tuHao+".png", x, y, g);
			break;
		default: 
			break;
		}
	}
	
	public void faShePaoDan()
	{
		zt = Ö²Îï×´Ì¬.·¢ÉäÅÚµ¯;
	}
	
	
}
