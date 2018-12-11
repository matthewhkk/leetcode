package done;

public class RectangleArea {
	
	public static void main(String... args)
	{
		RectangleArea rArea = new RectangleArea();
		System.out.println(rArea.computeArea(-3,0,3,4,0,-1,9,2));
	}


	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {

		int area1 = xyArea(A, B, C, D);
		int area2 = xyArea(E, F, G, H);

		// Actually this part is not needed
		// since by minus commonArea, the total cover part will be removed.
		if (A <= E && B <= F && C >= G && D >= H) {
			return area1;
		} else if (A >= E && A <= G && B > F && B <= H && C >= E && C <= G
				&& D >= F && D <= H) {
			return area2;
		}

		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		if (A <= G && B <= H) {
			x1 = Math.max(A, E);
			y1 = Math.max(B, F);
		}
		else 
		{
			return area1 + area2;
		}

		if (C >= E && D >= F) {
			x2 = Math.min(C, G);
			y2 = Math.min(D, H);
		}
		else 
		{
			return area1 + area2;
		}

		int commonArea = xyArea(x1, y1, x2, y2);

		return area1 + area2 - commonArea;
	}

	public int xyArea(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) * Math.abs(y1 - y2);
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class Rectangle {
		public Point a;
		public Point b;
		public Point c;
		public Point d;
		public int area;

		public Rectangle(Point a, Point c) {
			this.a = a;
			this.c = c;
			b = new Point(a.x, c.y);
			d = new Point(c.x, a.y);
			area = rectArea(a, c);
		}

	}

	public int rectArea(Point a, Point b) {
		return Math.abs(a.x - b.x) * Math.abs(a.y - b.y);
	}
}
