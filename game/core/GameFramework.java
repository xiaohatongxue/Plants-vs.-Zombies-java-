package colin.game.core;
 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.MemoryImageSource;

import javax.swing.*;

public class GameFramework
{
	private ChuangKou	ck	= null;
	private DingShiQi	ds1	= null;
	 
	public GameFramework(int k,int g,int shiJian)
	{
		初始构造();

		ck = new ChuangKou();
		//窗口 宽+2*立体边, 高+2*立体边+标题栏
		ck.setSize(5 * 2 + k, g + 2 * 5 + 25);
		ck.setResizable(false);
		//设定窗口可见性setVisible  true/false
		ck.setVisible(true);
		//延时的毫秒
		ds1 = new DingShiQi(shiJian);
		
	}

	class ChuangKou extends JFrame
	{
		ShuBiaoQi	sb	= null;
		JianPanQi	jp	= null;
		MianBan		mb	= null;
		//GraphicsDevice device;
		
		ChuangKou()
		{
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//			hideCursor();
			//~~~~~~~~~~~~~~~~~~~~~~~~
		 	
			//TODO 全屏显示游戏
			//setUndecorated(true);//去掉标题栏 
			//DisplayMode chiCun =null;//默认分辨率
			
			//DisplayMode chiCun = new DisplayMode(800, 600, 32, 0);//设计窗口分辨率
		//	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		  //  device = environment.getDefaultScreenDevice();
		  //  device.setFullScreenWindow(this);
		  ///  try 
		  //    {
		  //      device.setDisplayMode(chiCun);
		   //   } catch (IllegalArgumentException ex) {}
			sb = new ShuBiaoQi();
			jp = new JianPanQi();
			mb = new MianBan();

			this.addKeyListener(jp);
			mb.addMouseListener(sb);
			mb.addMouseMotionListener(sb);
			this.add(mb);
			this.addWindowListener(new ChuangKouLinstener());
			this.repaint();
		 
			 
		}
		/**
		 * 隐藏鼠标
		 */
		public void hideCursor()
		{
			 Image image = Toolkit.getDefaultToolkit().createImage(
					    new MemoryImageSource(0, 0, new int[0], 0, 0));
					  this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image,
					    new Point(0, 0), null));
		}

		class ChuangKouLinstener extends WindowAdapter
		{
			public void windowClosing(WindowEvent e)
			{
//			    Window window = device.getFullScreenWindow();
//			    if (window != null) {
//			      window.dispose();
//			    }
//			    device.setFullScreenWindow(null);
				ds1.stop();
				System.exit(0);
			}
		}
		
		class ShuBiaoQi extends MouseAdapter implements MouseMotionListener//子类覆盖
		{
			public void mouseClicked(MouseEvent e)//鼠标单击
			{
				//mx my鼠标的位置
				int mx = e.getX();
				int my = e.getY();
				//鼠标左键	BUTTON1、右键BUTTON3
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					鼠标左键单击(mx, my,e.getClickCount());
				}
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					鼠标右键单击(mx, my);
				}
				repaint();
			}

			public void mouseMoved(MouseEvent e)//鼠标移动
			{
				int mx = e.getX();
				int my = e.getY();
				 
				鼠标移动(mx, my);
				repaint();
			}

			public void mouseDragged(MouseEvent e)//鼠标拖动
			{
				int mx = e.getX();
				int my = e.getY();
			 
				鼠标拖动(mx, my);
				repaint();
			}

			public void mousePressed(MouseEvent e)
			{
				int mx = e.getX();
				int my = e.getY();
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					鼠标左键按下(mx, my);
				}
				else if (e.getButton() == MouseEvent.BUTTON3)
				{
					鼠标右键按下(mx, my);
				}
				repaint();
			}

			public void mouseReleased(MouseEvent e)
			{
				int mx = e.getX();
				int my = e.getY();
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					鼠标左键抬起(mx, my);
				}
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					鼠标右键抬起(mx, my);
				}
				repaint();
			}

		}

		class JianPanQi extends KeyAdapter//子类覆盖
		{
			public void keyPressed(KeyEvent e)
			{
				switch (e.getKeyCode()) 
				{
				case    KeyEvent.VK_F2:
					stop();
					break;
				case    KeyEvent.VK_F3:
					start();
					break;
				case    KeyEvent.VK_ESCAPE:
					ChuangKouLinstener ckjt = new ChuangKouLinstener();
					ckjt.windowClosing(null);
					break;
				default: 
					break;
				}
				键盘按下(e.getKeyCode());
				repaint();
			}

			public void keyReleased(KeyEvent e)
			{
				
				键盘抬起(e.getKeyCode() );
				repaint();
			}
		}

		class MianBan extends JPanel
		{
			
			
			
			public void paint(Graphics g)
			{
				全局显示(g);
			}
			
		}

		
	}

	public class DingShiQi  extends Timer 
	{
		 
		public DingShiQi(int delay )
		{
			super(delay, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					全局定时();
					ck.repaint();
				}
			});
			start();
		}
	}

	//---------------------------------------------------------------------------------------------
	//TODO:变量“声明”在此

	//TODO:事件方法在下边实现=区隔框架与 业务

	protected void 初始构造()
	{
	}

	protected void 全局显示(Graphics g)
	{
	}

	protected  void 全局定时()
	{
		
	}

	protected 	void 鼠标左键单击(int mx, int my, int clickcount)
	{
	}

	protected void 鼠标右键单击(int mx, int my)
	{
	}

	protected void 鼠标移动(int mx, int my)
	{
	}

	protected  void 鼠标拖动(int mx, int my)
	{
		
	}

	protected void 鼠标左键按下(int mx, int my)
	{
	}

	protected void 鼠标右键按下(int mx, int my)
	{
	}

	protected void 鼠标左键抬起(int mx, int my)
	{	
	}

	protected  void 鼠标右键抬起(int mx, int my)
	{
	}

	protected void 键盘抬起(int keyCode)
	{
		 
	}

	protected  void 键盘按下(int keyCode)
	{
	}
	/**
	 * 绘制图像
	 * @param path
	 * @param x
	 * @param y
	 * @param g
	 */
	public static  void drawImage(String path,int x,int y,Graphics g)
	{
		Image  tu=(new ImageIcon( path)).getImage();		
		g.drawImage(tu,x,y,null);
	}
	/**
	 * 停止定时器
	 */
	void stop()
	{
		ds1.stop();
	}
	/**
	 * 开始定时器
	 */
	void start()
	{
		ds1.start();
	}
	/**
	 * 改变速度值
	 * @param suDu
	 */
	void setSuDu(int suDu)
	{
		ds1.setDelay(suDu);
	}
	/**
	 * 得到速度值
	 * @return
	 */
	int getSuDu()
	{
		return ds1.getDelay();
	}
	
	public static void main(String[] args)
	{
		new GameFramework(100, 100, 100);
	}
}

