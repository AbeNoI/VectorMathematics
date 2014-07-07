
/**
 * <i><b> Class VectorPlane represents a vector plane within the RxRxR (3d-space) </b></i>
 * @author Abe_No_I
 * @date: 07/07/2014
 * @version: 1.0
 *
 */
public class VectorPlane {
	// vectors describing the VectorPlane instance
	Vector a; // Vector to the plane
	Vector b; // ONE Vector along the plane corresponding to the next (C)
	Vector c; // ONE Vector along the plane (orthogonal to vector b)
	Vector n; // the normal of the plane
	double d; // the distance of the dropped perpendicular from (0,0,0) towards the plane
	
	/**
	* <i> Constructor for creating a plane in <b>cartesic form: E(x): V(ap)*V(n) = d</b></i>
	 * @param np : the normal vector  dropped perpendicular onto the plane
	 * @param dp: the distance of the dropped perpendicular from (0,0,0) towards the plane
	 */
	public VectorPlane(Vector np, double dp){
		setABCVectors(np,dp);
	}
	
	/**
	 	* <i> Constructor for creating a plane in <b>cartesic form: E(x) = V(ap) + s*V(bp) + t*V(cp)</b></i>
	 * @param ap : the Vector to the plane
	 * @param bp: ONE Vector along the plane corresponding to the next (cp)
	 * @param cp: ONE Vector along the plane (orthogonal to vector bp)
	 */
	public VectorPlane(Vector ap, Vector bp, Vector cp) {
		this.a = ap;
		this.b = bp;
		this.c = cp;
		normalizePlane();
	}
	/**
	* <i> setting normal vector and distance of plane, recalculatin a,b,c not implemented yet</b></i>
	 * @param np : the normal vector  dropped perpendicular onto the plane
	 * @param dp: the distance of the dropped perpendicular from (0,0,0) towards the plane
	 */
	private void setABCVectors(Vector np, double dp){
		this.n =np;
		this.d = dp;
		//calculateOrthogonalVectors();
		//System.out.println("calculated orth");
	}
	
//	private void calculateOrthogonalVectors() {
//		 Vector[] orthoVectors = VectorPlane.getPointAndOrthoVectors(this.n, this.d);
//		 this.a = orthoVectors[0];
//		 this.b = orthoVectors[1];
//		 this.c = orthoVectors[2];
//	}

	/**
	 * <i> Merhod for getting all point coordinates on the plane if in./decreasing s + t</i>
	 * @param s : the constant value of <b>E(x): V(a) + s* V(b) + t*V(c)</b></i>
	 * @param t : the constant value of <b>E(x): V(a) + s* V(b) + t*V(c)</b></i>
	 * @return :  ONE s/t combination leads to One point (vector) on an VectorPlane instance
	 */
	public Vector getPointAsVectorOfPlane(double s, double t){
		return (new Vector(this.a.x + this.b.x * s + this.c.x * t, this.a.y + this.b.y * s + this.c.y * t, this.a.z + this.b.z * s + + this.c.z * t));
		}
	/**
	 * doing transformation from cartesic to Hesse format of plane instance
	 */
	private void normalizePlane(){
		Vector A = Vector.vectorProduct(b, c);
		double r = Vector.scalarProduct(this.a, A);
		Vector np = Vector.multiplyScalar( A, (1.0/Vector.getLength(A)));
		double dp = (1.0/Vector.getLength(A))*r;
		setABCVectors(np, dp);
	}
	
	/**
	 * method returns the intersection point between VectorPlane and VectorLine instances
	 * @param g : the VectorLine instance
	 * @param e : the VectorPlane instance
	 * @param radius : the radius for the new valus ( radius = 6 -> vector (-6,-6,-6) up to (6,6,6)
	 * @return : the intersection point( vector) of VectorPlane and VectorLine instances
	 */
	public static Vector getIntersectionPoint(VectorLine g, VectorPlane e, double radius){

		double foundParameter = 0.0;
		for (double i= -radius; i < radius; i+= 0.00001){
			
			double value =  e.n.x*(g.a.x + i*g.b.x) + 
							e.n.y*(g.a.y + i*g.b.y) + 
							e.n.z*(g.a.z + i*g.b.z);
			
			if(value < e.d + 0.0001 && value > e.d - 0.0001){
				
				return new Vector( 	g.a.x + i*(g.b.x), 		
									g.a.y + i*(g.b.y), 		
									g.a.z + i*(g.b.z) );
			}
		}
		 return null;
	}
	/**
	 * not yet implemented, but for retransformation a Hesse form into the cartesic one
	 * @param nV : the normal of the VectorPlane instance
	 * @param dp: the distance of the dropped perpendicular from (0,0,0) towards the plane
	 * @return : the thre vectors a,b,c in a Vector-Array (Vector[])
	 */
	public static Vector[] getPointAndOrthoVectors(Vector nV, double dp){
		double min = 5000;
		double max = 0.0;
		Vector[] orthoVectors = new Vector[3];
		for(double x =-50.0;x<50.0;x+=0.01){
			for(double y =-50.0;y<50.0;y+=0.01){
				for(double z =-50.0;z<50.0;z+=0.01){
					
					double value =  nV.x*x + nV.y*y + nV.z*z - dp;
					if(value>max)max=value;
					if(value<min)min=value;
					
			
					if(value < 0.1 && value > -0.1){
						Vector ap = Vector.multiplyScalar(nV, 1.0/dp);
						Vector bp = new Vector(x,y,z);
						Vector cp = Vector.getOneOrthoVector(bp);
						orthoVectors[0] = ap;
						orthoVectors[1] = bp;
						orthoVectors[2] = cp;
						return orthoVectors;
					}
				}
			}
		}
		return orthoVectors;
	}
	/**
	 * <i>toString() method <b>(cartesic form) for System.out</b></i>
	 * @param vp : vector to be converted into String
	 * @param length : the length of the fractional number part 
	 * @return : the converted VectorPlane instance as String
	 */
	public static String toString(VectorPlane vp, int length){
		return ("E: " + Vector.toString(vp.a, length) + " + r*" + Vector.toString(vp.b, length) + " + s*" + Vector.toString(vp.c, length) );
	}
	/**
	 * <i>toString() method <b>(Hesse form) for System.out</b></i>
	 * @param vn : normal vector to be converted into String
	 * @param length : the length of the fractional number part 
	 * @return : the converted VectorPlane instance as String
	 */
	public static String toStringHesse(VectorPlane vp, int length){
		return ("E(hesse): (x;y;z) * " + Vector.toString(vp.n, length) + " = " + vp.d	);
	}

}

