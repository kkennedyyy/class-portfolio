
public class Lab6 {

	public static void p(String s)
	{
		System.out.println(s);
	}
	
	public static void blank()
	{
		System.out.println();
	}
	
	public static void main(String[] args) {
		/*
		 * Beginning of Circle tests
		 */
		p("START OF CIRCLE TESTS");
		
		blank();
		
		Circle c = new Circle();
		String output = c.toString();
		p("Expected output Test 1: ");
		p("The area of the circle is: 0.0");
		
		p("Actual output Test 1: ");
		p(c.toString());

		blank();
		
		c.setRadius(5);
		p("Expected output Test 2: ");
		p("The area of the circle is: 78.53981633974483");
		
		p("Actual output Test 2: ");
		p(c.toString());
		
		blank();
		
		Circle c1 = new Circle(8);
		p("Expected output Test 3: ");
		p("The area of the circle is: 201.06192982974676");
		
		p("Actual output Test 3: ");
		p(c1.toString());
		
		blank();
		
		p("Expected output Test 4: ");
		p("false");
		
		p("Actual output Test 4: ");
		p(c1.equals(c) + "");
		
		blank();
		
		c1.setRadius(5);
		p("Expected output Test 5: ");
		p("true");
		
		p("Actual output Test 5: ");
		p(c1.equals(c) + "");
		
		blank();
		
		p("Expected output Test 6: ");
		p("5.0");
		
		p("Actual output Test 6: ");
		p(c1.getRadius() + "");
		
		blank();
		
		/*
		 * End of Circle tests
		 * Beginning of Rectangle Tests
		 */
		
		p("START OF RECTANGLE TESTS");
		
		blank();
		
		Rectangle r = new Rectangle();
		
		p("Expected output for Test 7: ");
		p("The area of the rectangle is: 0.0");
		
		p("Actual output for Test 7: ");
		p(r.toString());
		
		blank();
		
		r.setHeight(5);
		r.setLength(3);
		p("Expected output for Test 8: ");
		p("The area of the rectangle is: 15.0");
		
		p("Actual output for Test 8: ");
		p(r.toString());
		
		blank();
		
		Rectangle r1 = new Rectangle(5, 10);
		p("Expected output for Test 9: ");
		p("The area of the rectangle is: 50.0");
		
		p("Actual output for Test 9: ");
		p(r1.toString());
		
		blank();
		
		p("Expected output for Test 10: ");
		p("false");
		
		p("Actual output for Test 10: ");
		p(r.equals(r1) + "");
		
		blank();
		
		r.setHeight(10);
		r.setLength(5);
		p("Expected output for Test 11: ");
		p("true");
		
		p("Actual output for Test 11: ");
		p(r.equals(r1) + "");
		
		blank();
		
		p("Expected output for Test 12: ");
		p("5.0 10.0");
		
		p("Actual output for Test 12: ");
		p(r.getLength() + " " + r.getHeight());
		
		blank();
		
		/*
		 * End of Rectangle tests
		 * Beginning of Triangle tests
		 */
		
		p("START OF TRIANGLE TESTS");
		
		blank();
		
		Triangle t = new Triangle();
		
		p("Expected output for Test 13: ");
		p("The area of the triangle is: 0.0");
		
		p("Actual output for Test 13: ");
		p(t.toString());
		
		blank();
		
		t.setHeight(5);
		t.setLength(3);
		p("Expected output for Test 14: ");
		p("The area of the triangle is: 7.5");
		
		p("Actual output for Test 14: ");
		p(t.toString());
		
		blank();
		
		Triangle t1 = new Triangle(5, 10);
		p("Expected output for Test 15: ");
		p("The area of the triangle is: 25.0");
		
		p("Actual output for Test 15: ");
		p(t1.toString());
		
		blank();
		
		p("Expected output for Test 16: ");
		p("false");
		
		p("Actual output for Test 16: ");
		p(t.equals(t1) + "");
		
		blank();
		
		t.setHeight(10);
		t.setLength(5);
		p("Expected output for Test 17: ");
		p("true");
		
		p("Actual output for Test 17: ");
		p(t.equals(t1) + "");
		
		blank();
		
		p("Expected output for Test 18: ");
		p("5.0 10.0");
		
		p("Actual output for Test 18: ");
		p(t.getLength() + " " + t.getHeight());
		
		blank();
		
		p("TESTS ARE DONE");
	}

}


