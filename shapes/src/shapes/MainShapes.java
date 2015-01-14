/**
 * Author: Beni Kula
 * Creating date: Dec 28 2014
 * Last modified: Dec 28 2014
 * Description: Shapes.
 * */

package shapes;

public class MainShapes {

	public static void main(String[] args) {
		Shape[] shapesArr = new Shape[11];
		shapesArr[0] = new Triangle();
		shapesArr[1] = new Triangle(1, 2, 15, 3);
		shapesArr[2] = new Triangle(1, 4, 3, 3);
		shapesArr[3] = new Rectangle();
		shapesArr[4] = new Rectangle(3, 65, 265, 1);
		shapesArr[5] = new Rectangle(321, 66, 65, 33);
		shapesArr[6] = new Square();
		shapesArr[7] = new Square(212, 63, 3);
		shapesArr[8] = new Square(55, 33, 61);
		shapesArr[9] = new Circle();
		shapesArr[10] = new Circle(55, 33, 61);
		
		for (int i = 0; i < shapesArr.length; i++) {			
			System.out.println(shapesArr[i]);
		}
		
		System.out.println(shapesArr[1] + " == \n" + (shapesArr[2]) + " ? \n\t" + shapesArr[1].equals(shapesArr[2]));
	}

}
