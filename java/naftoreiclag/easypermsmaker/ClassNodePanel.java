package naftoreiclag.easypermsmaker;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ClassNodePanel extends JPanel
{
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
		
		this.add(butt_newNode);
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
		
		WinDecorat.drawWindowBoarder(graphics, 50, 150, 200, 100, true);
		WinDecorat.drawWindowBoarder(graphics, 50, 50, 200, 100, false);
	}
}