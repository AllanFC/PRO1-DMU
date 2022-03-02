package simple;

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
		// Remember to initialise all fields.
		this.faceCount = faceCount;
		faceValue = 0;
	}

	/**
	 * Creates a die with 6 faces and a random face value.
	 */
	public Die() {
		faceCount = 6;
		faceValue = rd.nextInt(6) + 1;
	}

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
		// TODO
		faceValue = rd.nextInt( faceCount) + 1;
	}
}