package effective.java.item8.EqualsContract;

import java.sql.Timestamp;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import effective.java.item.utility.RuntimeUtilities;

public class RightThings {
	Thread activeEntity = new Thread();

	Random random = new Random();

	AbstractSet set = new HashSet();

	@Override
	public boolean equals(Object o) {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		Object o = new Object();
		Object o1 = o;
		Object o2 = o1;
		System.out.println(o.equals(o1)); // Symmetric
		System.out.println(o1.equals(o));
		System.out.println(o1.equals(o)); // Reflexive
		System.out.println(o1.equals(null)); // Non null
		System.out.println(o.equals(o1)); // Transitive
		System.out.println(o1.equals(o2)); //
		System.out.println(o.equals(o2)); //
		RuntimeUtilities.timePrint(() -> System.out.println(o.equals(o1)), 2009); // Consistent
		
		String s = "Symmetric";
		CaseInsensitiveString cis = new CaseInsensitiveString(s);
		
		System.out.println(cis.equals(s));
		System.out.println(s.equals(cis));		
		
		List<CaseInsensitiveString> cisList = new ArrayList<CaseInsensitiveString>();
		cisList.add(cis);
		
		System.out.println(cisList.contains(s));
		
		int x=0,y=0,z=0;
		Point p = new Point(x,y);
		Point3D p3d = new Point3D(x,y,z);
		System.out.println(p.equals(p3d));
		System.out.println(p3d.equals(p));
		
		z = 1;
		Point3D p3d1 = new Point3D(x,y,z);
		System.out.println(p3d.equals(p));
		System.out.println(p.equals(p3d1));
		System.out.println(p3d.equals(p3d1));
		
		Timestamp ts = new Timestamp(1000);
		Date d = new Date(1000);
		
		System.out.println(ts.equals(d));
		System.out.println(d.equals(ts));
		
		
		
	}
	
	

	// Broken - violates symmetry!
	public static final class CaseInsensitiveString {
		private final String s;

		public CaseInsensitiveString(String s) {
			if (s == null)
				throw new NullPointerException();
			this.s = s;
		} // Broken - violates symmetry!

		@Override
		public boolean equals(Object o) {
			if (o instanceof CaseInsensitiveString)
				return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
			if (o instanceof String) // One-way interoperability!
				return s.equalsIgnoreCase((String) o);
			return false;
		} // Remainder omitted}
	}
	
	public static class Point{
		int x;
		int y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if(! (o instanceof Point))
				return false;
			
			// Broken - violates Liskov substitution principle (page 40)
			/*if(o==null || o.getClass() != getClass())
				return false;*/
			
			Point p = (Point)o;
			return p.x == this.x && p.y == this.y;
		}
	}
	
	public static final class Point3D extends Point {
		int z;
		
		public Point3D(int x, int y, int z) {
			super(x, y);
			this.z = z;
		}
		
		@Override 
		public boolean equals(Object o) {
			if(!(o instanceof Point3D))
				return false;
			
			// z-blind comparison , at the expense of transitivity
			if(!(o instanceof Point)) {
				return o.equals(this);
			}
						
			return super.equals(o) && ((Point3D) o).z == this.z;
		}
		
	}
	
	public static final class Point4D{
		Point p1;
		Point p2;
		
		public Point4D(int x,int y,int z,int k) {
			p1 = new Point(x,y);
			p2 = new Point(z,k);
		}
		
		@Override 
		public boolean equals(Object o) {
			if(!(o instanceof Point4D))
				return false;
			Point4D p = (Point4D)o;
			
			return p.p1.equals(this.p1) && p.p2.equals(this.p2);
		}
	}
	
	
	
}
