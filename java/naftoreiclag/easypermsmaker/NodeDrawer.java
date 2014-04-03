package naftoreiclag.easypermsmaker;

import java.awt.Graphics;
import java.awt.Image;

public class NodeDrawer
{
	public static Image node_normal;
	public static Image node_root;
	public static Image node_global;
	
	public static Image node_selection;
	
	public static int ai;
	public static int bi;
	public static int ci;
	public static int xi;
	public static int yi;
	public static int zi;
	
	public static void drawNode(Graphics g, int x, int y, int width, int height, NodeType nt, boolean highlight)
	{
		Image skin = null;
		
		switch(nt)
		{
			case normal:
			{
				skin = node_normal;
				break;
			}
			case root:
			{
				skin = node_root;
				break;
			}
			case global:
			{
				skin = node_global;
				break;
			}
			case highlight:
			{
				skin = node_selection;
				break;
			}
			default:
			{
				break;
			}
		}
		
		drawNodeSkinned(g, x, y, width, height, skin);
		
		if(highlight)
		{
			drawNodeSkinned(g, x, y, width, height, node_selection);
		}
	}
	
	public static void drawNodeSkinned(Graphics g, int x, int y, int width, int height, Image skin)
	{
		x -= 5;
		y -= 5;
		width += 10;
		height += 10;
		
		int mw = (width - ai) - ci;
		int mh = (height - xi) - zi;
		
		// top left
		g.drawImage(skin, x,       y,       x+ai,       y+xi,       0,     0,     ai,       xi,       null);
		
		// top
		g.drawImage(skin, x+ai,    y,       x+ai+mw,    y+xi,       ai,    0,     ai+bi,    xi,       null);
		
		// top right
		g.drawImage(skin, x+ai+mw, y,       x+ai+mw+ci, y+xi,       ai+bi, 0,     ai+bi+ci, xi,       null);
		
		// left
		g.drawImage(skin, x,       y+xi,    x+ai,       y+xi+mh,    0,     xi,    ai,       xi+yi,    null);
		
		// middle
		g.drawImage(skin, x+ai,    y+xi,    x+ai+mw,    y+xi+mh,    ai,    xi,    ai+bi,    xi+yi,    null);
		
		// right
		g.drawImage(skin, x+ai+mw, y+xi,    x+ai+mw+ci, y+xi+mh,    ai+bi, xi,    ai+bi+ci, xi+yi,    null);
		
		// bottom left
		g.drawImage(skin, x,       y+xi+mh, x+ai,       y+xi+mh+zi, 0,     xi+yi, ai,       xi+yi+zi, null);
		
		// bottom
		g.drawImage(skin, x+ai,    y+xi+mh, x+ai+mw,    y+xi+mh+zi, ai,    xi+yi, ai+bi,    xi+yi+zi, null);
		
		// bottom right
		g.drawImage(skin, x+ai+mw, y+xi+mh, x+ai+mw+ci, y+xi+mh+zi, ai+bi, xi+yi, ai+bi+ci, xi+yi+zi, null);
	}
}
