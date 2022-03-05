package pig;

import java.util.Random;

public class Die {
	// number of faces
	private int faceCount;
	// value of upper face
	private int faceValue;

	private Random rd = new Random();

	/**
	 * Creates a die with the given face count and a random face value.
	 */
	public Die(int faceCount) {
		// TODO
		// Remember to initialise all fields.
		this.faceCount = faceCount;
		faceValue = rd.nextInt(6) + 1;
	}

	/**
	 * Creates a die with 6 faces and a random face value.
	 */
	// TODO: Make another constructor
	public Die() {
		faceCount = 6;
		faceValue = rd.nextInt(6) + 1;
	}

	// TODO: make getters
	public int getFaceValue() {
		return faceValue;
	}

	public int getFaceCount() {
		return faceCount;
	}

	/**
	 * Rolls the die, resulting in a new face value.
	 */
	public void roll() {
		faceValue = rd.nextInt( faceCount) + 1 ;
	}
}