package naftoreiclag.easypermsmaker.utilities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WinDecorat
{
	public static Image winSkin;
	public static int ai;
	public static int bi;
	public static int ci;
	public static int xi;
	public static int yi;
	public static int zi;
	
	public static void drawWindowBoarder(Graphics g, int x, int y, int width, int height)
	{
		int mw = (width - ai) - ci;
		int mh = (height - xi) - zi;
		
		// top left
		g.drawImage(winSkin, x,       y,       x+ai,       y+xi,       0,     0,     ai,       xi,       null);
		
		// top
		g.drawImage(winSkin, x+ai,    y,       x+ai+mw,    y+xi,       ai,    0,     ai+bi,    xi,       null);
		
		// top right
		g.drawImage(winSkin, x+ai+mw, y,       x+ai+mw+ci, y+xi,       ai+bi, 0,     ai+bi+ci, xi,       null);
		
		// left
		g.drawImage(winSkin, x,       y+xi,    x+ai,       y+xi+mh,    0,     xi,    ai,       xi+yi,    null);
		
		// middle
		g.drawImage(winSkin, x+ai,    y+xi,    x+ai+mw,    y+xi+mh,    ai,    xi,    ai+bi,    xi+yi,    null);
		
		// right
		g.drawImage(winSkin, x+ai+mw, y+xi,    x+ai+mw+ci, y+xi+mh,    ai+bi, xi,    ai+bi+ci, xi+yi,    null);
		
		// bottom left
		g.drawImage(winSkin, x,       y+xi+mh, x+ai,       y+xi+mh+zi, 0,     xi+yi, ai,       xi+yi+zi, null);
		
		// bottom
		g.drawImage(winSkin, x+ai,    y+xi+mh, x+ai+mw,    y+xi+mh+zi, ai,    xi+yi, ai+bi,    xi+yi+zi, null);
		
		// bottom right
		g.drawImage(winSkin, x+ai+mw, y+xi+mh, x+ai+mw+ci, y+xi+mh+zi, ai+bi, xi+yi, ai+bi+ci, xi+yi+zi, null);
	}
}
