import java.util.Scanner;

class Points{
	 double x2;
	 double x1;
	 double y1;
	 double y2;
}
class Line extends Points{
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}
	public void setY2(double y2) {
		this.y2 = y2;
	}
	public double calc(Line a) {
		@SuppressWarnings("unused")
		double slope;
		return slope = (a.y2 - a.y1)/(a.x2 - a.x1);
	}
}
public class Intersection {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Line P1Q1 = new Line();
		Line P2Q2 = new Line();
		P1Q1.setX1(s.nextDouble());
		P1Q1.setX2(s.nextDouble());
		P1Q1.setY1(s.nextDouble());
		P1Q1.setY2(s.nextDouble());
		P2Q2.setX1(s.nextDouble());
		P2Q2.setX2(s.nextDouble());
		P2Q2.setY1(s.nextDouble());
		P2Q2.setY2(s.nextDouble());
		s.close();
		if(P1Q1.calc(P1Q1) == P2Q2.calc(P2Q2))
			System.out.println("They do not intersect");
		else
			System.out.println("They Intersect");	
	}
}
