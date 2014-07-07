/**
 * Just testing proggie
 * @author Abe_No_I
 * @date: 07/07/2014
 * @version: 1.0
 *
 */
public class MathProgram {

	public MathProgram() {
		
	}

	public static void main(String[] args) {
		new MathProgram().run();
	}

	private void run() {
		
//		Vector a = new Vector(1.0,1.0,1.0);
//		Vector b = new Vector(1.0,-1.0,0.0);
//		Vector c = new Vector(0.0,-1.0,1.0);
//		
//		VectorPlane E = new VectorPlane(a, b, c);
		Vector n =new Vector(4.0,4.0,4.0);
		double dp = 5.0;
		VectorPlane E = new VectorPlane(n,dp);
		
		System.out.println( VectorPlane.toStringHesse(E, 3) );
		
		// korrekte Ergebnisse soweit
		
		Vector d = new Vector(1.0,1.0,1.0);
		Vector f = new Vector(2.0,2.0,2.0);
		VectorLine G = new VectorLine(d, f);
		
		System.out.println(VectorLine.toString(G, 3));
	
		Vector interSectionPoint = VectorPlane.getIntersectionPoint(G, E, 50.0);
		System.out.println("IntersectionPoint of E and G: " +  Vector.toString(interSectionPoint, 3));
		
//		Vector n1 = new Vector(1.0,2.0,3.0);
//		VectorPlane plane = new VectorPlane(n1, 1.0);
		
		
	}

}
