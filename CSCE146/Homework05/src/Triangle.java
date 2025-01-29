//Written by Kennedy Poag
import java.awt.*;
import javax.swing.JFrame;

public class Triangle extends Canvas{
	//Limit on pixel size
	public static final int PIXELLIMIT = 4;
	public static void main(String[] args) throws Exception{
		//create jframe
		JFrame frame = new JFrame("Sierpenski's Triangle");
		//set frame size 
		frame.setSize(800,800);
		//create triangle object
		Triangle t = new Triangle();
		//add triangle object to frame
		frame.add(t);
		//set frame visibility to true
		frame.setVisible(true);
		//set background color
		frame.setBackground(Color.black);
	}
	public void paint(Graphics g) {
		//call draw triangle method
		drawTriangle(0, 0, this.getSize().width, g, true);
	}
	//method to draw triangle
	public void drawTriangle(int x, int y, int side, Graphics g, boolean isFirst) {
		//array to store x and y vertices
		int[] xPoints = new int[3];	
		int[] yPoints = new int[3];
		//scale for triangles
		int scale = side/4;
		//draws outer triangle/first
		if(isFirst) {
			//first vertex
			xPoints[0] = side/2;
			yPoints[0]=0;
			//second vertex
			xPoints[1] = 0;
			yPoints[1]= side;
			//third vertex
			xPoints[2] = side;
			yPoints[2]=side;
			//change color and fill
			g.setColor(Color.PINK);
			g.fillPolygon(xPoints, yPoints, 3);
		}
		//first vertex inner triangle
		xPoints[0] = x+(side/4);
		yPoints[0]= y+(side/2);
		//second vertex on inner triangle
		xPoints[1] = x+(side/2);
		yPoints[1]= y+side;
		//third vertex of inner triangle
		xPoints[2] = x+(3*side/4);
		yPoints[2]=y+(side/2);
		//set color and fill
		g.setColor(getBackground());
		g.fillPolygon(xPoints, yPoints, 3);
		//if scale is greater or equal to the pixel limit, draw inner triangles
		if(scale>= PIXELLIMIT) {
			drawTriangle(x+scale, y, 2*scale, g, false);
			drawTriangle(x+(2*scale), y+(2*scale), 2*scale, g, false);
			drawTriangle(x,y+(2*scale), 2*scale, g, false);
			
		}
	}

}