package pig;

public class DiceThrower {
	// 2 dice with face count of 6 each
	private Die die1;

	// Fields:
	// 1. The roll count.
	private int rollCount;


	/**
	 * Creates a DiceThrower object.
	 */
	public DiceThrower(){
		die1 = new Die();
		rollCount = 0;
	}

	public int getRollCount() {
		return rollCount;
	}

	/**
	 * Rolls the 2 dice.
	 */
	public void roll() {
		die1.roll();
		rollCount += 1;
	}

	/**
	 * Returns the sum of the face values in a roll.
	 */
	public int sum() {
		return die1.getFaceValue();
	}
}
