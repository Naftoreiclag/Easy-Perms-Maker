package naftoreiclag.easypermsmaker;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ClassNodePanel extends JPanel
{
	private boolean ldown;
	private boolean mdown;
	private boolean rdown;
	private boolean lup;
	private boolean mup;
	private boolean rup;
	
	private PermClass selectedOne;
	private int cox;
	private int coy;
	
	protected final JButton butt_newNode;
	
	public final Image image;
	public final int imageWidth;
	public final int imageHeight;

	public ClassNodePanel(Image image)
	{
		super();
		
		if(image != null)
		{
			this.image = image;
			this.imageWidth = image.getWidth(this);
			this.imageHeight = image.getHeight(this);
		}
		else
		{
			this.image = null;
			this.imageWidth = 0;
			this.imageHeight = 0;
		}
		
		butt_newNode = new JButton("New Node");
		
		butt_newNode.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				onNewNodeButtClicked();
			}
		});
		
		this.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e){ mClicked(e); }
			@Override
			public void mouseEntered(MouseEvent e){ mEntered(e); }
			@Override
			public void mouseExited(MouseEvent e){ mExited(e); }
			@Override
			public void mousePressed(MouseEvent e){ mPressed(e); }
			@Override
			public void mouseReleased(MouseEvent e){ mReleased(e); }
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseDragged(MouseEvent e){ mDrag(e); }
			@Override
			public void mouseMoved(MouseEvent e){ mMove(e); }
		});
		
		this.add(butt_newNode);
	}
	
	public void onNewNodeButtClicked()
	{
		PermClass p = new PermClass("dog");
		PermData.getData().classes.add(p);
		
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		
		if(imageWidth == 0 || imageHeight == 0)
		{
			return;
		}
		
		for(int x = 0; x < this.getWidth(); x += imageWidth)
		{
			for(int y = 0; y < this.getHeight(); y += imageHeight)
			{
				graphics.drawImage(image, x, y, imageWidth, imageHeight, this);
			}
		}
		
		for(PermClass p : PermData.getData().classes)
		{
			NodeDrawer.drawNode(graphics, p.x, p.y, 30, 30, p == selectedOne);
			
			for(PermClass p2 : p.inheritsFrom)
			{
				graphics.drawLine(p.x, p.y, p2.x, p2.y);
			}
		}
	}

	public void mClicked(MouseEvent e){ }

	public void mEntered(MouseEvent e){ }

	public void mExited(MouseEvent e)
	{
		ldown = false;
		mdown = false;
		rdown = false;
	}

	public void mPressed(MouseEvent e)
	{
		ldown = SwingUtilities.isLeftMouseButton(e);
		mdown = SwingUtilities.isMiddleMouseButton(e);
		rdown = SwingUtilities.isRightMouseButton(e);
		
		selectedOne = getClassUnderPoint(e.getX(), e.getY());
		
		System.out.println(e.getX() + "," + e.getY());
		System.out.println(selectedOne);
		
		this.repaint();
	}

	public void mReleased(MouseEvent e)
	{
		if(rdown)
		{
			PermClass p = getClassUnderPoint(e.getX(), e.getY());
			
			if(p != null)
			{
				selectedOne.inheritsFrom.add(p);
			}
		}
		
		ldown = false;
		mdown = false;
		rdown = false;
	}
	
	public void mMove(MouseEvent e)
	{
		if(ldown)
		{
			if(selectedOne != null)
			{
				selectedOne.x = e.getX() - cox;
				selectedOne.y = e.getY() - coy;
				
				this.repaint();
			}
		}
	}
	
	public PermClass getClassUnderPoint(int x, int y)
	{
		for(PermClass p : PermData.getData().classes)
		{
			if(x >= p.x && x <= p.x + 30 && y >= p.y && y <= p.y + 30)
			{
				
				cox = x - p.x;
				coy = y - p.y;
				return p;
			}
		}
		
		return null;
	}
	
	public void mDrag(MouseEvent e){ mMove(e); }
}