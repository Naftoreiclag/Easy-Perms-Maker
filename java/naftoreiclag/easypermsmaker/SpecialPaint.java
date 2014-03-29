package naftoreiclag.easypermsmaker;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

public class SpecialPaint
{
	public static void drawNodeConnection(Graphics2D graphics2D, int ax, int ay, int bx, int by)
	{
		double distance = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
		
		Point2D.Double a = new Point2D.Double(ax, ay); // Start
		Point2D.Double b = new Point2D.Double(bx, by); // End
		
		Point2D.Double av = new Point2D.Double(distance * 0.5d, 0); // Start vector
		Point2D.Double bv = new Point2D.Double(distance * -0.5d, 0); // End vector

		CubicCurve2D.Double curve = new CubicCurve2D.Double(
				a.x, a.y, 
				a.x + av.x, a.y + av.y, 
				b.x + bv.x, b.y + bv.y, 
				b.x, b.y);

		BasicStroke thick = new BasicStroke(5.0f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER, 10.0f);

		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		graphics2D.setStroke(thick);
		graphics2D.draw(curve);
	}
}
