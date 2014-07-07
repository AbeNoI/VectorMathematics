
/**
 * <i><b> Class Vector represents a vector within the RxRxR (3d-space)
 * @author Abe_No_I
 * @date: 07/07/2014
 * @version: 1.0
 *
 */
public class Vector {
	// the components of this vector instance 
	double x;	// x-component
	double y;	// y-component
	double z;	// z-component
	/**
	 * 
	 * <i> Constructing vector instanve with carthesic coordinates (x,y,z) </i>
	 * @param xp : the x-coordinate
	 * @param yp : the y-coordinate
	 * @param zp : the z-coordinate
	 * 
	 */
	public Vector(double xp, double yp, double zp) {
		this.x = xp;
		this.y = yp;
		this.z = zp;
	}
	/**
	 * <i> adding two vector instances to one result vector </i>
	 * @param a : Vector a to add
	 * @param b : Vector b to add
	 * @return : The resulting vector of the addition
	 */
	public static Vector add(Vector a, Vector b){
		return (new Vector(a.x+b.x, a.y+b.y, a.z+b.z));
	}
	/**
	 * <i> multiply a vector instances with a scalar </i> 
	 * @param a : Vector a to multiply wit factor k
	 * @param k : factor k to scalar-multiply the vector a
	 * @return : the resulting verktor of scalar multiplication
	 */
	public static Vector multiplyScalar(Vector a, double k){
		return (new Vector(a.x * k, a.y*k, a.z*k));
	}
	/**
	 * <i> estimating the scalar product for two vectors </i>
	 * @param a : Vector a for scalar product building
	 * @param b : Vector b for scalar product building
	 * @return : the resulting scalar of scalar product building
	 */
	public static double scalarProduct(Vector a, Vector b){
		return (a.x*b.x + a.y*b.y + a.z*b.z);
	}
	/**
	 * <i> estimating the vector (cross) product for two vectors </i>
	 * @param a : Vector a for vector (cross) product building
	 * @param b : Vector b for vector (cross) product building
	 * @return : the resulting vector of vector (cross) product building
	 */
	public static Vector vectorProduct(Vector a, Vector b){
		double aComponent = (a.y*b.z - a.z*b.y);
		double bComponent = (a.z*b.x - a.x*b.z);
		double cComponent = (a.x*b.y - a.y*b.x);
		Vector scalarProduct = new Vector(aComponent,bComponent,cComponent);
		return scalarProduct;
	}
	/**
	 * <i>getting the length of a vector</i>
	 * @param a : Vector a, which length is to estimate
	 * @return : the length of the vector a
	 */
	public static double getLength(Vector a){
		return (Math.sqrt(a.x*a.x + a.y*a.y + a.z*a.z));
	}
	/**
	 * <i>normalize a Vector to Length 1</i>
	 * @param a : Vector a to normalize to length 1
	 * @return : the normalized Vector of length 1
	 */
	public static Vector normVector(Vector a){
		double ratio = getLength(a);
		return (new Vector(a.x/ratio, a.y/ratio, a.z/ratio));
	}
	/**
	 * <i>toString() method for System.out</i>
	 * @param vp : vector to be converted into String
	 * @param length : the length of the fractional number part 
	 * @return : the converted Vector as String
	 */
	public static String toString(Vector vp, int length){
		Vector vpS = Vector.roundToOutput(vp, length);
		return ("[(" + vpS.x + ");(" + vpS.y + ");(" + vpS.z + ")]");
	}
	
	/**
	 * <i> not implemented yet</i>
	 * @param ap
	 * @return
	 */
	public static Vector getOneOrthoVector(Vector ap) {
		// 2,1 wird zu ->  -1,2 oder 1,-2
		// 1,2,3 wird zu   Einem -1,2,anyZ oder 1,-2,anyZ oder zu 4 anderen, die möglich sind
						
		
		// ich entscheide mal einfach für den ersten.
		return (new Vector(-ap.y, ap.x, ap.z));
	}
	/**
	 * <i> rounds to a fixed size of the rational part of a decimal number (double) </i>
	 * @param ap : The vector, which components are rounded
	 * @return : The resulting vector wit rounded components
	 */
	public static Vector roundToOutput(Vector vpS, int length){
		Vector returnVector = null;
		double rad = 1.0;
		switch(length){
		case 8: 	rad *=10.0; 
		case 7: 	rad *=10.0; 
		case 6: 	rad *=10.0; 
		case 5: 	rad *=10.0; 
		case 4: 	rad *=10.0; 
		case 3: 	rad *=10.0; 
		case 2: 	rad *=10.0; 
		case 1: 	rad *=10.0; 
		
		default: 
		}
		double x = ((int)(vpS.x * (int)rad))/rad;
		double y = ((int)(vpS.y * (int)rad))/rad;
		double z = ((int)(vpS.z * (int)rad))/rad;
		returnVector = new Vector(x, y, z);
		return returnVector;
	}
}
