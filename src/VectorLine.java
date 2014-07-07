/**
 * <i><b> Class VectorLine represents a vector line within the RxRxR (3d-space) </b></i>
 * @author Abe_No_I
 * @date: 07/07/2014
 * @version: 1.0
 *
 */
public class VectorLine {

	// Cectors describing the entire VectorLine instance
	public Vector a; // the vector TO the line
	public Vector b; // the vector along (arallel to) the line
	
	/**
	 * <i> Constructor for creating a line in <b>cartesic form: G(x) = V(ap) + r* V(bp)</b></i>
	 * @param ap : Vector ap is the vector to a point onto the line
	 * @param bp: Vector bp is the vector pointing paralelly to the line
	 */
	public VectorLine(Vector ap, Vector bp) {
		this.a = ap; 
		this.b = bp;
	}
	/**
	 * <i> Merhod for getting all point coordinates along the line if in./decreasing r</i>
	 * @param r : the constant value of <b>G(x) = V(ap) + r* V(bp)</b></i>
	 * @return : ONE r leads to One point (vector) on an VectorLine instance
	 */
	public Vector getPointAsVectorOfLine(double r){
		return (new Vector(this.a.x + this.b.x * r, this.a.y + this.b.y * r, this.a.z + this.b.z * r));
	}
	/**
	* <i>toString() method for System.out</i>
	 * @param vl : VectorLine to be converted into String
	 * @param length : the length of the fractional number part of the vectors 
	 * @return : the converted VectorLine as String
	 */
	public static String toString(VectorLine vl, int length){
		return ("G: " + Vector.toString(vl.a, length) + " + t*" + Vector.toString(vl.b, length) );
	}

}
