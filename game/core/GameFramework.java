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
		��ʼ����();

		ck = new ChuangKou();
		//���� ��+2*�����, ��+2*�����+������
		ck.setSize(5 * 2 + k, g + 2 * 5 + 25);
		ck.setResizable(false);
		//�趨���ڿɼ���setVisible  true/false
		ck.setVisible(true);
		//��ʱ�ĺ���
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
		 	
			//TODO ȫ����ʾ��Ϸ
			//setUndecorated(true);//ȥ�������� 
			//DisplayMode chiCun =null;//Ĭ�Ϸֱ���
			
			//DisplayMode chiCun = new DisplayMode(800, 600, 32, 0);//��ƴ��ڷֱ���
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
		 * �������
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
		
		class ShuBiaoQi extends MouseAdapter implements MouseMotionListener//���า��
		{
			public void mouseClicked(MouseEvent e)//��굥��
			{
				//mx my����λ��
				int mx = e.getX();
				int my = e.getY();
				//������	BUTTON1���Ҽ�BUTTON3
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					����������(mx, my,e.getClickCount());
				}
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					����Ҽ�����(mx, my);
				}
				repaint();
			}

			public void mouseMoved(MouseEvent e)//����ƶ�
			{
				int mx = e.getX();
				int my = e.getY();
				 
				����ƶ�(mx, my);
				repaint();
			}

			public void mouseDragged(MouseEvent e)//����϶�
			{
				int mx = e.getX();
				int my = e.getY();
			 
				����϶�(mx, my);
				repaint();
			}

			public void mousePressed(MouseEvent e)
			{
				int mx = e.getX();
				int my = e.getY();
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					����������(mx, my);
				}
				else if (e.getButton() == MouseEvent.BUTTON3)
				{
					����Ҽ�����(mx, my);
				}
				repaint();
			}

			public void mouseReleased(MouseEvent e)
			{
				int mx = e.getX();
				int my = e.getY();
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					������̧��(mx, my);
				}
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					����Ҽ�̧��(mx, my);
				}
				repaint();
			}

		}

		class JianPanQi extends KeyAdapter//���า��
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
				���̰���(e.getKeyCode());
				repaint();
			}

			public void keyReleased(KeyEvent e)
			{
				
				����̧��(e.getKeyCode() );
				repaint();
			}
		}

		class MianBan extends JPanel
		{
			
			
			
			public void paint(Graphics g)
			{
				ȫ����ʾ(g);
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
					ȫ�ֶ�ʱ();
					ck.repaint();
				}
			});
			start();
		}
	}

	//---------------------------------------------------------------------------------------------
	//TODO:�������������ڴ�

	//TODO:�¼��������±�ʵ��=��������� ҵ��

	protected void ��ʼ����()
	{
	}

	protected void ȫ����ʾ(Graphics g)
	{
	}

	protected  void ȫ�ֶ�ʱ()
	{
		
	}

	protected 	void ����������(int mx, int my, int clickcount)
	{
	}

	protected void ����Ҽ�����(int mx, int my)
	{
	}

	protected void ����ƶ�(int mx, int my)
	{
	}

	protected  void ����϶�(int mx, int my)
	{
		
	}

	protected void ����������(int mx, int my)
	{
	}

	protected void ����Ҽ�����(int mx, int my)
	{
	}

	protected void ������̧��(int mx, int my)
	{	
	}

	protected  void ����Ҽ�̧��(int mx, int my)
	{
	}

	protected void ����̧��(int keyCode)
	{
		 
	}

	protected  void ���̰���(int keyCode)
	{
	}
	/**
	 * ����ͼ��
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
	 * ֹͣ��ʱ��
	 */
	void stop()
	{
		ds1.stop();
	}
	/**
	 * ��ʼ��ʱ��
	 */
	void start()
	{
		ds1.start();
	}
	/**
	 * �ı��ٶ�ֵ
	 * @param suDu
	 */
	void setSuDu(int suDu)
	{
		ds1.setDelay(suDu);
	}
	/**
	 * �õ��ٶ�ֵ
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

