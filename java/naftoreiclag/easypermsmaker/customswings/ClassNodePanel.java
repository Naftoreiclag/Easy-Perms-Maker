package naftoreiclag.easypermsmaker.customswings;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import naftoreiclag.easypermsmaker.utilities.WinDecorat;

@SuppressWarnings("serial")
public class ClassNodePanel extends JPanel
{
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
		
		WinDecorat.drawWindowBoarder(graphics, 50, 50, 200, 100);
	}
}