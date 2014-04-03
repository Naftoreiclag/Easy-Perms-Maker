package naftoreiclag.easypermsmaker;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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
	
	private int mx;
	private int my;
	
	private PermClass selectedOne;
	private int cox;
	private int coy;
	
	protected final JButton butt_newNode;
	
	public Font font;
	
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
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D graphics = (Graphics2D) g;
		
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
			for(PermClass p2 : p.inheritsFrom)
			{
				SpecialPaint.drawNodeConnection((Graphics2D) graphics, p.x + 30, p.y + 15, p2.x, p2.y + 15);
			}
		}
		

		
		if(selectedOne != null)
		{
			if(rdown)
			{
				SpecialPaint.drawNodeConnection((Graphics2D) graphics, selectedOne.x + 30, selectedOne.y + 15, mx, my);
			}
		}

		for(PermClass p : PermData.getData().classes)
		{
			//(int) font.getStringBounds("Hello World", graphics.getFontRenderContext()).getWidth()
			NodeDrawer.drawNode(graphics, p.x, p.y, 30, 30, NodeType.global, p == selectedOne);
			//graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			//		RenderingHints.VALUE_ANTIALIAS_ON);
			//graphics.setFont(font);

			//graphics.drawString("Hello World", p.x, p.y);

		}
	}

	public void mClicked(MouseEvent e){ }

	public void mEntered(MouseEvent e){ }

	public void mExited(MouseEvent e)
	{
		ldown = false;
		mdown = false;
		rdown = false;
		
		this.repaint();
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
			PermClass nodeToAdd = getClassUnderPoint(e.getX(), e.getY());
			
			if(nodeToAdd != null)
			{
				boolean shouldAdd = true;
				
				if(nodeToAdd == selectedOne)
				{
					shouldAdd = false;
				}
				
				for(PermClass is : selectedOne.inheritsFrom)
				{
					if(is == nodeToAdd)
					{
						shouldAdd = false;
						
						break;
					}
				}
				
				if(shouldAdd)
				{
					selectedOne.inheritsFrom.add(nodeToAdd);
					
					System.out.println("Add!");
				}
			}
			
			this.repaint();
		}
		
		ldown = false;
		mdown = false;
		rdown = false;
	}
	
	public void mMove(MouseEvent e)
	{
		mx = e.getX();
		my = e.getY();
		
		if(ldown)
		{
			if(selectedOne != null)
			{
				selectedOne.x = e.getX() - cox;
				selectedOne.y = e.getY() - coy;
				
				this.repaint();
			}
		}
		if(rdown)
		{
			if(selectedOne != null)
			{
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